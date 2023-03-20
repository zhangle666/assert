package com.virtue.shiro.realms;

import com.virtue.pojo.Perms;
import com.virtue.pojo.User;
import com.virtue.service.SystemService;
import com.virtue.service.UserService;

import com.virtue.utils.ApplicationContextUtils;
import com.virtue.utils.MyByteSource;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.List;


public class CustomerRealm extends AuthorizingRealm {
    @Autowired
    private SessionDAO sessionDAO;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        System.out.println("调用授权验证：" + primaryPrincipal);
        // 根据主权限信息获取角色和权限信息
        SystemService userService = (SystemService) ApplicationContextUtils.getBean("systemService"); // 直接注入不可行？
            User user = userService.findRolesByUserName(primaryPrincipal);
        // 授权角色用户信息
        if(!CollectionUtils.isEmpty(user.getRoles())){

            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

            // 这里内部对用户角色和权限做了一个连接并添加到授权信息中
            user.getRoles().forEach(role->{
                simpleAuthorizationInfo.addRole(role.getName()); //添加角色信息

                //权限信息
                List<Perms> perms = userService.findPermsByRole(role.getId());

                if(!CollectionUtils.isEmpty(perms) && perms.get(0)!=null ){
                    perms.forEach(perm->{
                        simpleAuthorizationInfo.addStringPermission(perm.getName());
                    });
                }
            });
            return simpleAuthorizationInfo;
        }

            return null;


    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String username = (String) authenticationToken.getPrincipal();
        SystemService userService = (SystemService) ApplicationContextUtils.getBean("systemService");

        // 2.根据身份信息做查询
        User user = userService.findByUserName(username);
        // 3.用户不为空，则返回数据库信息
        if (!ObjectUtils.isEmpty(user)) {
            Collection<Session> sessions = sessionDAO.getActiveSessions();
            for (Session session : sessions) {
                User users = (User) session.getAttribute("USER_SESSION");
                if (users != null) {
                    if (username.equals(users.getUsername())) {
                        session.setTimeout(0);
                    }
                }
            }

            // 3.1返回数据库中的信息，底层和用户输入的信息做校验

            Session shiroSession = SecurityUtils.getSubject().getSession();
            shiroSession.setAttribute("USER_SESSION", user);
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUsername(),
                    user.getPassword(),
                    new MyByteSource(user.getSalt()), // 需要自己去实现salt的序列化
                    this.getName());
            return simpleAuthenticationInfo;
        }
        return null;
        }
    }

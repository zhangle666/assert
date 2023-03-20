package com.virtue.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.virtue.mapper.SystemMapper;
import com.virtue.mapper.UserMapper;
import com.virtue.model.ReturnParam;
import com.virtue.pojo.Perms;
import com.virtue.pojo.User;
import com.virtue.service.SystemService;
import com.virtue.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service("systemService")
public class SystemServiceImpl implements SystemService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SystemMapper userMapper;
    @Resource
    private MailServiceImpl mailService;
    @Override
    public Boolean register(User user) {

        String confirmCode = IdUtil.getSnowflake(1, 1).nextIdStr();
        String salt = RandomUtil.randomString(8);
        Md5Hash md5Hash=new Md5Hash(user.getPassword(),salt,1024);
        LocalDateTime ldt = LocalDateTime.now().plusDays(1);
        user.setSalt(salt);
        user.setPassword(md5Hash.toHex());
        user.setConfirmCode(confirmCode);
        user.setActivationTime(ldt);
        user.setJobid("el"+RandomUtil.randomNumbers(4));
        System.out.println(user);
        if ( userMapper.register(user)>0){
                String activationUrl="http://119.29.85.150:81/activation?confirmCode="+confirmCode;
                mailService.sedMailForActivationAccount(activationUrl,user.getEmail());
            return true;
        }

        return false ;

    }

    @Override
    public User findByUserName(String username) {
        User user = userMapper.findByUserName(username);
       return user;
    }

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @param code 验证码
     * @param session 把验证码存入session
     * @return
     */
    @Override
    public ReturnParam loginCheck(String username , String password, String code, HttpSession session){


        if (username.equals("")||password.equals("") ||code.equals("")){

                    return new ReturnParam(false,406,"输入的信息不能为空");
                }


            String verifyCode = (String) session.getAttribute("verifyCode");
            System.out.println(verifyCode);
            if (verifyCode.equalsIgnoreCase(code)){
                User userName = userMapper.findByUserName(username);
                if (userName==null){
                    return new ReturnParam(false,402,"用户名或密码错误") ;
                }
                try {
                    //获取主体对象
                    Subject subject = SecurityUtils.getSubject();
                    subject.login(new UsernamePasswordToken(username,password));
                    session.setAttribute("user",userName);

                   Session shiorSession = SecurityUtils.getSubject().getSession();

                   User user = (User) shiorSession.getAttribute("USER_SESSION");

                   DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                    String date=format.format(new Date());

                    ValueOperations operations = redisTemplate.opsForValue();
                  String s = (String) operations.get(userName.getUsername()+"loginTime");
                  operations.set(username+"loginTime",date);
                    return new ReturnParam(true ,200,s);
                } catch (UnknownAccountException e) {
                    return new ReturnParam(false,402,"用户名或密码错误") ;
                } catch (IncorrectCredentialsException e) {
                    e.printStackTrace();
                    return new ReturnParam(false,402,"用户名或密码错误") ;
                } catch (LockedAccountException e) {
                    return new ReturnParam(false,405,"账户被锁定");
                }catch (UnknownSessionException e){
                    return new ReturnParam(false,202,"你已经登录了");
                }

            }
              return new ReturnParam(false,400,"验证码错误");
           }

    /**
     * 根据用户名查询角色
     * @param username
     * @return
     */
    @Override
    public User findRolesByUserName(String username) {
        return userMapper.findRolesByUserName(username);
    }


    /**
     *
     * @param id 根据角色查询权限
     * @return
     */
    @Override
    public List<Perms> findPermsByRole(String id) {
        return userMapper.findPermsByRole(id);
    }

    /**
     * 用户退出
     * @return
     */
    @Override
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()){
            try {
                subject.logout();
            }catch (Exception e){
                System.out.println("11111");
            }


        }

    }
  @Override
  public   ReturnParam activationAccount(String confirmCode){
      User user = userMapper.selectUserByConfirmCode(confirmCode);
      System.out.println(user);
      boolean after = LocalDateTime.now().isAfter(user.getActivationTime());
      if (after){
          return new ReturnParam(false,"链接已经失效");
      }
      int i = userMapper.updateUserByConfirmCode(confirmCode);
      if (i>0){
          return new ReturnParam(true,"激活成功！");
      }
else {
          return new ReturnParam(false,"激活失败！");
      }

  }

    @Override
    public User selectByJobid(String jobid) {
        return userMapper.selectByJobid(jobid);
    }

    @Override
    public void updateByJobid(User user) {
        userMapper.updateById(user);
    }


}

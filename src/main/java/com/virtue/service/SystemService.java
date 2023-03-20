package com.virtue.service;


import com.virtue.model.ReturnParam;
import com.virtue.pojo.Perms;
import com.virtue.pojo.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface SystemService {
    /**
     * 用户注册
     * @param user
     * @return
     */
    Boolean register(User user);

    User findByUserName(String username);

    /**
     * 登录验证
     * @param username 用户名
     * @param password 密码
     * @param code 验证码
     * @param session 把验证码存入session
     * @return
     */
     ReturnParam loginCheck(String username, String password , String code, HttpSession session);

    /**
     * 查询用户角色
     * @return 返回用户角色集合
     */
    User findRolesByUserName(String username);

    List<Perms> findPermsByRole(String id);

    void logout();

    /**
     * 用户注册激活账户
     * @param confirmCode
     * @return
     */
    ReturnParam activationAccount(String confirmCode);

    User selectByJobid(String jobid);


    void updateByJobid(User user);
}

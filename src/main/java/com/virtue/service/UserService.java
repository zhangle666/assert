package com.virtue.service;


import com.baomidou.mybatisplus.core.metadata.IPage;

import com.virtue.pojo.*;

import java.util.List;

public interface UserService {

    List<User> findAll();

    /**
     * 添加用户
     * @param user
     * @return
     */
    Boolean save(User user);

    /**
     * 获取单个信息
     * @param jobid
     * @return
     */
    User getById(String jobid);

    /**
     * 修改信息
     * @param user
     * @return
     */
    boolean update(User user);
    Boolean deleteById(String jobid);

    /**
     * 分页查询
     * @param currenPage
     * @param pageSize
     * @param user
     * @return
     */
    IPage<User> getPage(int currenPage, int pageSize, User user );

    /**
     * 修改状态
     * @param jobid
     * @param isValid
     * @return
     */
    Boolean  updateIsValidById(String jobid,Integer isValid);

    /**
     * 查询用户是否存在
     * @param acname
     * @return
     */
    Boolean checkAcname(String acname);



}

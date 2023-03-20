package com.virtue.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.pojo.Personnel;
import com.virtue.pojo.User;

import java.util.List;

public interface PersonnelService {

    List<Personnel> findAll();

    /**
     * 添加用户
     * @param personnel
     * @return
     */
    Boolean save(Personnel personnel);

    /**
     * 获取单个信息
     * @param peid
     * @return
     */
    Personnel getById(Integer peid);

    /**
     * 修改信息
     * @param personnel
     * @return
     */
    boolean update(Personnel personnel);
    Boolean deleteById(Integer peid);

    /**
     * 分页查询
     * @param currenPage
     * @param pageSize
     * @param personnel
     * @return
     */
    IPage<Personnel> getPage(int currenPage, int pageSize, Personnel personnel );

    /**
     * 查询用户是否存在
     * @param acname
     * @return
     */
    Boolean checkAcname(String acname);

}

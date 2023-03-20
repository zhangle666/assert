package com.virtue.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.pojo.Maintain;

import java.util.List;

public interface MaintainService {

    List<Maintain> findAll();

    /**
     * 添加用户
     * @param maintain
     * @return
     */
    Boolean save(Maintain maintain);

    /**
     * 获取单个信息
     * @param maid
     * @return
     */
    Maintain getById(Integer maid);

    /**
     * 修改信息
     * @param maintain
     * @return
     */
    boolean update(Maintain maintain);
    Boolean deleteById(Integer maid);

    /**
     * 分页查询
     * @param currenPage
     * @param pageSize
     * @param maintain
     * @return
     */
    IPage<Maintain> getPage(int currenPage, int pageSize, Maintain maintain );

    /**
     * 查询用户是否存在
     * @param acname
     * @return
     */
    Boolean checkAcname(String acname);


    Maintain selectWaidByBoid(Integer maid);

}

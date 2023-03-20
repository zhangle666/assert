package com.virtue.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.pojo.Store;
import com.virtue.pojo.Supplier;

import java.util.List;

public interface StoreService {
    List<Store> findAll();

    /**
     * 添加用户
     * @param store
     * @return
     */
    Boolean save(Store store);

    /**
     * 获取单个信息
     * @param stid
     * @return
     */
    Store getById(Integer stid);

    /**
     * 修改信息
     * @param store
     * @return
     */
    boolean update(Store store);
    Boolean deleteById(String stid);

    /**
     * 分页查询
     * @param currenPage
     * @param pageSize
     * @param store
     * @return
     */
    IPage<Store> getPage(int currenPage, int pageSize,Store store);

    /**
     * 修改状态
     * @param stid
     * @param isValid
     * @return
     */
    Boolean   updateIsValidById(Integer stid,Integer isValid);

    /**
     * 查询用户是否存在
     * @param acname
     * @return
     */
    Boolean checkAcname(String acname);
}

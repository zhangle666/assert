package com.virtue.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.pojo.Achieve;
import com.virtue.pojo.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> findAll();

    /**
     * 添加用户
     * @param supplier
     * @return
     */
    Boolean save(Supplier supplier);

    /**
     * 获取单个信息
     * @param supid
     * @return
     */
    Supplier getById(Integer supid);

    /**
     * 修改信息
     * @param supplier
     * @return
     */
    boolean update(Supplier supplier);
    Boolean deleteById(String supid);

    /**
     * 分页查询
     * @param currenPage
     * @param pageSize
     * @param supplier
     * @return
     */
    IPage<Supplier> getPage(int currenPage, int pageSize,Supplier supplier);

    /**
     * 修改状态
     * @param supid
     * @param isValid
     * @return
     */
    Boolean   updateIsValidById(Integer supid,Integer isValid);

    /**
     * 查询用户是否存在
     * @param acname
     * @return
     */
    Boolean checkAcname(String acname);
}

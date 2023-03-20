package com.virtue.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.pojo.Transfer;

import java.util.List;

public interface TransferService {

    List<Transfer> findAll();

    /**
     * 添加用户
     * @param transfer
     * @return
     */
    Boolean save(Transfer transfer);

    /**
     * 获取单个信息
     * @param trid
     * @return
     */
    Transfer getById(Integer trid);

    /**
     * 修改信息
     * @param transfer
     * @return
     */
    boolean update(Transfer transfer);
    Boolean deleteById(Integer trid);

    /**
     * 分页查询
     * @param currenPage
     * @param pageSize
     * @param transfer
     * @return
     */
    IPage<Transfer> getPage(int currenPage, int pageSize, Transfer transfer );

    /**
     * 查询用户是否存在
     * @param acname
     * @return
     */
    Boolean checkAcname(String acname);

}

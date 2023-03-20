package com.virtue.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.pojo.Warehous;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface WarehousService {

    List<Warehous> findAll();

    /**
     * 添加用户
     * @param warehous
     * @return
     */
    Boolean save(Warehous warehous);

    /**
     * 获取单个信息
     * @param waid
     * @return
     */
    Warehous getById(Integer waid);

    /**
     * 修改信息
     * @param warehous
     * @return
     */
    boolean update(Warehous warehous);
    Boolean deleteById(Integer waid);

    /**
     * 分页查询
     * @param currenPage
     * @param pageSize
     * @param warehous
     * @return
     */
    IPage<Warehous> getPage(int currenPage, int pageSize, Warehous warehous );

    /**
     * 查询用户是否存在
     * @param acname
     * @return
     */
    Boolean checkAcname(String acname);
     void downloadAllWarehous(HttpServletResponse response);
}

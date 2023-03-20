package com.virtue.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.pojo.Retirement;
import com.virtue.pojo.Subscribe;

import java.util.List;

public interface SubscribeService {

    List<Subscribe> findAll();

    /**
     * 添加用户
     * @param subscribe
     * @return
     */
    Boolean save(Subscribe subscribe);

    /**
     * 获取单个信息
     * @param suid
     * @return
     */
    Subscribe getById(Integer suid);

    /**
     * 修改信息
     * @param subscribe
     * @return
     */
    boolean update(Subscribe subscribe);
    Boolean deleteById(Integer suid);

    /**
     * 分页查询
     * @param currenPage
     * @param pageSize
     * @param subscribe
     * @return
     */
    IPage<Subscribe> getPage(int currenPage, int pageSize, Subscribe subscribe );

    /**
     * 查询用户是否存在
     * @param acname
     * @return
     */
    Boolean checkAcname(String acname);

  Boolean  updateIsvalidBySuId(Integer suid);
   Boolean updateIsvalidAndausBySuId(Subscribe subscribe);

}

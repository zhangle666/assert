package com.virtue.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.pojo.Scrap;


import java.util.List;

public interface ScrapService {
    List<Scrap> findAll();

    /**
     * 添加用户
     * @param scrap
     * @return
     */
    Boolean save(Scrap scrap);

    /**
     * 获取单个信息
     * @param scid
     * @return
     */
    Scrap getById(Integer scid);

    /**
     * 修改信息
     * @param scrap
     * @return
     */
    boolean update(Scrap scrap);
    Boolean deleteById(String scid);

    /**
     * 分页查询
     * @param currenPage
     * @param pageSize
     * @param scrap
     * @return
     */
    IPage<Scrap> getPage(int currenPage, int pageSize,Scrap scrap);

    /**
     * 修改状态
     * @param scid
     * @param isValid
     * @return
     */
    Boolean   updateIsValidById(Integer scid,Integer isValid);

    /**
     * 查询用户是否存在
     * @param acname
     * @return
     */
    Boolean checkAcname(String acname);
}

package com.virtue.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.pojo.Retirement;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface RetirementService {

    List<Retirement> findAll();

    /**
     * 添加用户
     * @param retirement
     * @return
     */
    Boolean save(Retirement retirement);

    /**
     * 获取单个信息
     * @param reid
     * @return
     */
    Retirement getById(Integer reid);

    /**
     * 修改信息
     * @param retirement
     * @return
     */
    boolean update(Retirement retirement);
    Boolean deleteById(Integer reid);

    /**
     * 分页查询
     * @param currenPage
     * @param pageSize
     * @param retirement
     * @return
     */
    IPage<Retirement> getPage(int currenPage, int pageSize, Retirement retirement );

    /**
     * 查询用户是否存在
     * @param acname
     * @return
     */
    Boolean checkAcname(String acname);


    Retirement selectWaidByBoid(Integer reid);

    Boolean updateIsvalid(Integer reid);

     void downloadAllRetirement(HttpServletResponse response);

}

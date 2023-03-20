package com.virtue.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.pojo.Borrowed;


import java.util.List;

public interface BorrowedService {

    List<Borrowed> findAll();

    /**
     * 添加用户
     * @param borrowed
     * @return
     */
    Boolean save(Borrowed borrowed);

    /**
     * 获取单个信息
     * @param boid
     * @return
     */
    Borrowed getById(Integer boid);

    /**
     * 修改信息
     * @param borrowed
     * @return
     */
    boolean update(Borrowed borrowed);
    Boolean deleteById(Integer boid);

    /**
     * 分页查询
     * @param currenPage
     * @param pageSize
     * @param borrowed
     * @return
     */
    IPage<Borrowed> getPage(int currenPage, int pageSize, Borrowed borrowed );

    /**
     * 查询用户是否存在
     * @param acname
     * @return
     */
    Boolean checkAcname(String acname);


    Borrowed selectWaidByBoid(Integer boid);

}

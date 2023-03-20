package com.virtue.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.model.ReturnParam;
import com.virtue.pojo.Department;
import com.virtue.pojo.Scrap;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();

    /**
     * 添加用户
     * @param department
     * @return
     */
    Boolean save(Department department);

    /**
     * 获取单个信息
     * @param deid
     * @return
     */
    Department getById(Integer deid);

    /**
     * 修改信息
     * @param department
     * @return
     */
    boolean update(Department department);
    Boolean deleteById(String deid);

    /**
     * 分页查询
     * @param currenPage
     * @param pageSize
     * @param department
     * @return
     */
    IPage<Department> getPage(int currenPage, int pageSize,Department department);

    /**
     * 修改状态
     * @param deid
     * @param isValid
     * @return
     */
    Boolean   updateIsValidById(Integer deid,Integer isValid);

    /**
     * 查询用户是否存在
     * @param acname
     * @return
     */
    Boolean checkAcname(String acname);
}

package com.virtue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.virtue.mapper.DepartmentMapper;
import com.virtue.pojo.Department;
import com.virtue.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentMapper mapper;
    @Override
    public List<Department> findAll() {

        return mapper.selectList(null);
    }

    @Override
    public Boolean save(Department department) {

            int insert = mapper.insert(department);
            return insert>0;


    }
    @Override
    public Department getById(Integer deid) {
        return mapper.selectById(deid);
    }

    @Override
    public boolean update(Department department) {
        return mapper.updateById(department)>0;
    }

    @Override
    public Boolean deleteById(String deid) {
        return mapper.deleteById(deid)>0;
    }



    @Override
    public IPage<Department> getPage(int currenPage, int pageSize, Department department) {
        IPage page=new Page(currenPage,pageSize);
        QueryWrapper<Department> wrapper = new QueryWrapper<>();
        String denub = department.getDenub();
        String dename = department.getDename();
        Integer isValid = department.getIsValid();
        if (!StringUtils.isEmpty(isValid)){
            wrapper.like("is_valid",isValid);
        }
        if (!StringUtils.isEmpty(dename)){
            wrapper.like("dename",dename);
        }
        if (!StringUtils.isEmpty(denub)){
            wrapper.like("denub",denub);
        }
        mapper.selectPage(page,wrapper);
        return page;
    }

    @Override
    public Boolean updateIsValidById(Integer deid, Integer isValid) {
        return mapper.updateIsValidById(deid,isValid);
    }

    @Override
    public Boolean checkAcname(String genrecode) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("genrecode",genrecode);
        Department scrap = mapper.selectOne(wrapper);
        return scrap!=null;
    }
}

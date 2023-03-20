package com.virtue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.virtue.mapper.SupplierMapper;
import com.virtue.pojo.Supplier;
import com.virtue.service.SupplierService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SupplierServiceImpl implements SupplierService {
    @Resource
    private SupplierMapper mapper;
    @Override
    public List<Supplier> findAll() {
        QueryWrapper<Supplier> wrapper = new QueryWrapper<>();
        wrapper.eq("is_valid",1);
        return mapper.selectList(wrapper);
    }

    @Override
    public Boolean save(Supplier supplier) {
        Supplier supname1 = mapper.selectBySupname(supplier.getSupname());
        if (supname1==null){
             return mapper.insert(supplier)>0;
        }else {
            return false;
        }

    }
    @Override
    public Supplier getById(Integer supid) {
        return mapper.selectById(supid);
    }

    @Override
    public boolean update(Supplier supplier) {
        Supplier supname2 = mapper.selectBySupname(supplier.getSupname());
        if (supname2==null){
            return mapper.updateById(supplier)>0;
        }else {
            return false;
        }

    }

    @Override
    public Boolean deleteById(String supid) {
        return mapper.deleteById(supid)>0;
    }



    @Override
    public IPage<Supplier> getPage(int currenPage, int pageSize, Supplier supplier) {
        IPage page=new Page(currenPage,pageSize);
        QueryWrapper<Supplier> wrapper = new QueryWrapper<>();
        String supname = supplier.getSupname();
        String contacts = supplier.getContacts();
        Integer isValid = supplier.getIsValid();
        if (!StringUtils.isEmpty(isValid)){
            wrapper.like("is_valid",isValid);
        }
        if (!StringUtils.isEmpty(contacts)){
            wrapper.like("contacts",contacts);
        }
        if (!StringUtils.isEmpty(supname)){
            wrapper.like("supname",supname);
        }
        mapper.selectPage(page,wrapper);
        return page;
    }

    @Override
    public Boolean updateIsValidById(Integer supid, Integer isValid) {
        return mapper.updateIsValidById(supid,isValid);
    }

    @Override
    public Boolean checkAcname(String genrecode) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("genrecode",genrecode);
        Supplier supplier = mapper.selectOne(wrapper);
        return supplier!=null;
    }
}

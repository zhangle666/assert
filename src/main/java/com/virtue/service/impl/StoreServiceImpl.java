package com.virtue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.virtue.mapper.StoreMapper;
import com.virtue.mapper.SupplierMapper;
import com.virtue.pojo.Store;
import com.virtue.pojo.Supplier;
import com.virtue.service.StoreService;
import com.virtue.service.SupplierService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    @Resource
    private StoreMapper mapper;
    @Override
    public List<Store> findAll() {
        QueryWrapper<Store> wrapper = new QueryWrapper<>();
        wrapper.eq("is_valid",1);
        return mapper.selectList(wrapper);
    }

    @Override
    public Boolean save(Store store) {
        try{
            int insert = mapper.insert(store);
            return insert>0;
        }catch (Exception e){
            return false;
        }

    }
    @Override
    public Store getById(Integer stid) {
        return mapper.selectById(stid);
    }

    @Override
    public boolean update(Store store) {
        return mapper.updateById(store)>0;
    }

    @Override
    public Boolean deleteById(String stid) {
        return mapper.deleteById(stid)>0;
    }



    @Override
    public IPage<Store> getPage(int currenPage, int pageSize, Store store) {
        IPage page=new Page(currenPage,pageSize);
        QueryWrapper<Store> wrapper = new QueryWrapper<>();
        String stname = store.getStname();
        String sttype = store.getSttype();
        Integer isValid = store.getIsValid();
        if (!StringUtils.isEmpty(isValid)){
            wrapper.like("is_valid",isValid);
        }
        if (!StringUtils.isEmpty(sttype)){
            wrapper.like("sttype",sttype);
        }
        if (!StringUtils.isEmpty(stname)){
            wrapper.like("stname",stname);
        }
        mapper.selectPage(page,wrapper);
        return page;
    }

    @Override
    public Boolean updateIsValidById(Integer stid, Integer isValid) {
        return mapper.updateIsValidById(stid,isValid);
    }

    @Override
    public Boolean checkAcname(String genrecode) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("genrecode",genrecode);
        Store store = mapper.selectOne(wrapper);
        return store!=null;
    }
}

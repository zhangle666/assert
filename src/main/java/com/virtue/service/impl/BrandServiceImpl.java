package com.virtue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.virtue.mapper.BrandMapper;
import com.virtue.mapper.GenresMapper;
import com.virtue.pojo.Brand;
import com.virtue.pojo.Genres;
import com.virtue.service.BrandService;
import com.virtue.service.GenresService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandMapper brandMapper;
    @Override
    public List<Brand> findAll() {
        QueryWrapper<Brand> wrapper = new QueryWrapper<>();
        wrapper.eq("is_valid",1);
        return brandMapper.selectList(wrapper);
    }

    @Override
    public Boolean save(Brand brand) {
        try{
            int insert = brandMapper.insert(brand);
            return insert>0;
        }catch (Exception e){
            return false;
        }

    }
    @Override
    public Brand getById(Integer brid) {
        return brandMapper.selectById(brid);
    }

    @Override
    public boolean update(Brand brand) {
        return brandMapper.updateById(brand)>0;
    }

    @Override
    public Boolean deleteById(String brid) {
        return brandMapper.deleteById(brid)>0;
    }



    @Override
    public IPage<Brand> getPage(int currenPage, int pageSize, Brand brand) {
        IPage page=new Page(currenPage,pageSize);
        QueryWrapper<Brand> wrapper = new QueryWrapper<>();
        String brnub = brand.getBrnub();
        String brname = brand.getBrname();
        Integer isValid = brand.getIsValid();
        if (!StringUtils.isEmpty(isValid)){
            wrapper.like("is_valid",isValid);
        }
        if (!StringUtils.isEmpty(brname)){
            wrapper.like("brname",brname);
        }
        if (!StringUtils.isEmpty(brnub)){
            wrapper.like("brnub",brnub);
        }
        brandMapper.selectPage(page,wrapper);
        return page;
    }

    @Override
    public Boolean updateIsValidById(Integer brid, Integer isValid) {
        return brandMapper.updateIsValidById(brid,isValid);
    }

    @Override
    public Boolean checkGenrecode(String genrecode) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("genrecode",genrecode);
        Brand brand = brandMapper.selectOne(wrapper);
        return brand!=null;
    }
}

package com.virtue.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.pojo.Brand;
import com.virtue.pojo.Genres;

import java.util.List;

public interface BrandService {

    List<Brand> findAll();

    Boolean save(Brand brand);

    Brand getById(Integer brid);

    boolean update(Brand brand);
    Boolean deleteById(String brid);
    IPage<Brand> getPage(int currenPage, int pageSize,Brand brand);

    Boolean   updateIsValidById(Integer brid,Integer isValid);
    Boolean checkGenrecode(String genrecode);

}

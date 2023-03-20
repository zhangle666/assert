package com.virtue.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.pojo.Achieve;
import com.virtue.pojo.Brand;
import com.virtue.pojo.Genres;

import java.util.List;

public interface AchieveService {

 List<Achieve> findAll();

 Boolean save(Achieve achieve);

 Achieve getById(Integer acid);

 boolean update(Achieve achieve);
 Boolean deleteById(String acid);
 IPage<Achieve> getPage(int currenPage, int pageSize,Achieve achieve);

 Boolean   updateIsValidById(Integer acid,Integer isValid);
 Boolean checkAcname(String acname);
}

package com.virtue.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.virtue.mapper.BorrowedMapper;
import com.virtue.mapper.SubscribeMapper;
import com.virtue.pojo.Borrowed;
import com.virtue.pojo.Subscribe;
import com.virtue.service.BorrowedService;
import com.virtue.service.SubscribeService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BorrowedServiceImpl implements BorrowedService {
    @Resource
    private BorrowedMapper mapper;

    @Override
    public List<Borrowed> findAll() {

        return mapper.findAll();
    }

    @Override
    public Boolean save(Borrowed borrowed) {
        DateFormat format=new SimpleDateFormat("yyyyMMdd");
        String s=format.format(new Date());
        borrowed.setBoorder("JY"+s+ RandomUtil.randomNumbers(5));
        borrowed.setIsValid("0");

            int insert = mapper.insert(borrowed);
            return insert>0;

    }
    @Override
    public Borrowed getById(Integer boid) {
        return mapper.findOneBySuid(boid);
    }

    @Override
    public boolean update(Borrowed borrowed) {
        return mapper.updateruturndate(borrowed)>0;
    }

    @Override
    public Boolean deleteById(Integer boid) {
        return mapper.deleteById(boid)>0;
    }



    @Override
    public IPage<Borrowed> getPage(int currenPage, int pageSize, Borrowed borrowed) {
        IPage page=new Page(currenPage,pageSize);
        QueryWrapper<Borrowed> wrapper = new QueryWrapper<>();
        String boorder = borrowed.getBoorder();
        String pename = borrowed.getPename();
        String waname = borrowed.getWaname();
        String isValid = borrowed.getIsValid();
        String gname = borrowed.getGname();
        if (!StringUtils.isEmpty(gname)){
            wrapper.like("g.gname",gname);
        }

        if (!StringUtils.isEmpty(isValid)){
            wrapper.like("b.is_valid",isValid);
        }
        if (!StringUtils.isEmpty(pename)){
            wrapper.like("p.pename",pename);
        }
        if (!StringUtils.isEmpty(boorder)){
            wrapper.like("b.boorder",boorder);
        }
        if (!StringUtils.isEmpty(waname)){
            wrapper.like("w.waname",waname);
        }
        if (!StringUtils.isEmpty(waname)){
            wrapper.like("w.waname",waname);
        }
        mapper.findByPage(page,wrapper);
        return page;
    }


    @Override
    public Boolean checkAcname(String genrecode) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("genrecode",genrecode);
        Borrowed scrap = mapper.selectOne(wrapper);
        return scrap!=null;
    }

    @Override
    public Borrowed selectWaidByBoid(Integer boid) {
        return mapper.selectWaidByBoid(boid);
    }


}

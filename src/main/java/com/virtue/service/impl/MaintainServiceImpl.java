package com.virtue.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.virtue.mapper.BorrowedMapper;
import com.virtue.mapper.MaintainMapper;
import com.virtue.mapper.MaintainwxMapper;
import com.virtue.pojo.Maintain;
import com.virtue.pojo.Maintainwx;
import com.virtue.service.BorrowedService;
import com.virtue.service.MaintainService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MaintainServiceImpl implements MaintainService {
    @Resource
    private MaintainMapper mapper;
    @Resource
    private MaintainwxMapper maintainwxMapper;
    @Override
    public List<Maintain> findAll() {

        return mapper.findAll();
    }

    @Override
    public Boolean save(Maintain maintain) {
        DateFormat format=new SimpleDateFormat("yyyyMMdd");
        String s=format.format(new Date());
        maintain.setMaorder("WX"+s+ RandomUtil.randomNumbers(5));
        maintain.setBdate(s);
        Integer waid = maintain.getWaid();
        Maintainwx maintainwx=new Maintainwx();
        int insert = mapper.insert(maintain);
        Maintain m = maintainwxMapper.selectByWaname(waid);
        if (m==null){
                maintainwx.setWaid(waid);
                maintainwx.setRef(1);
                maintainwx.setRepr(maintain.getExpense());
                maintainwxMapper.insertAll(maintainwx);

        }else {
            maintainwx.setWaid(waid);
            maintainwx.setRepr(maintain.getExpense());
        maintainwxMapper.updateByWaid(maintainwx);
        }
        return insert>0;


    }
    @Override
    public Maintain getById(Integer maid) {
        return mapper.findOneByMaid(maid);
    }

    @Override
    public boolean update(Maintain maintain) {
        return mapper.updateruturndate(maintain)>0;
    }

    @Override
    public Boolean deleteById(Integer maid) {
        return mapper.deleteById(maid)>0;
    }



    @Override
    public IPage<Maintain> getPage(int currenPage, int pageSize, Maintain maintain) {
        IPage page=new Page(currenPage,pageSize);
        QueryWrapper<Maintain> wrapper = new QueryWrapper<>();
        String boorder = maintain.getMaorder();
        String pename = maintain.getPename();
        String waname = maintain.getWaname();
        String gname = maintain.getGname();
        if (!StringUtils.isEmpty(gname)){
            wrapper.like("g.gname",gname);
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
        Maintain scrap = mapper.selectOne(wrapper);
        return scrap!=null;
    }

    @Override
    public Maintain selectWaidByBoid(Integer maid) {
        return mapper.selectWaidByBoid(maid);
    }


}

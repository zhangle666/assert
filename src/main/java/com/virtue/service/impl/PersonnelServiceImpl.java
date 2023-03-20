package com.virtue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.virtue.mapper.BorrowedMapper;
import com.virtue.mapper.PersonnelMapper;
import com.virtue.mapper.UserMapper;
import com.virtue.pojo.Borrowed;
import com.virtue.pojo.Personnel;
import com.virtue.pojo.User;
import com.virtue.service.BorrowedService;
import com.virtue.service.PersonnelService;
import com.virtue.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonnelServiceImpl implements PersonnelService {
    @Resource
    private PersonnelMapper mapper;
    @Resource
    private BorrowedMapper borrowedMapper;

    @Override
    public List<Personnel> findAll() {

        return mapper.selectList(null);
    }

    @Override
    public Boolean save(Personnel personnel) {
            int insert = mapper.insert(personnel);
            return insert>0;

    }
    @Override
    public Personnel getById(Integer peid) {
        return mapper.selectById(peid);
    }

    @Override
    public boolean update(Personnel personnel) {
        return mapper.updateById(personnel)>0;
    }

    @Override
    public Boolean deleteById(Integer peid)
    {
        Borrowed borrowed = borrowedMapper.selectByPeid(peid);
        if (borrowed==null){
            return mapper.deleteById(peid)>0;
        }else{
            return false;
        }


    }



    @Override
    public IPage<Personnel> getPage(int currenPage, int pageSize, Personnel personnel) {
        IPage page=new Page(currenPage,pageSize);
        QueryWrapper<Personnel> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("jobnub");
        String jobnub = personnel.getJobnub();
        String pename = personnel.getPename();
        if (!StringUtils.isEmpty(pename)){
            wrapper.like("pename",pename);
        }
        if (!StringUtils.isEmpty(jobnub)){
            wrapper.like("jobnub",jobnub);
        }
        mapper.findByPage(page,wrapper);
        return page;
    }


    @Override
    public Boolean checkAcname(String genrecode) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("genrecode",genrecode);
        Personnel scrap = mapper.selectOne(wrapper);
        return scrap!=null;
    }


}

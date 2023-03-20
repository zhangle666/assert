package com.virtue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.virtue.mapper.UserMapper;

import com.virtue.mapper.UserMapper;
import com.virtue.pojo.User;
import com.virtue.pojo.User;
import com.virtue.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

//@Service("userService")
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper mapper;
    @Override
    public List<User> findAll() {



       return null;
    }

    @Override
    public Boolean save(User user) {
//        DateFormat format=new SimpleDateFormat("yyyyMMdd");
//        String s=format.format(new Date());
//        subscribe.setSuorder("SG"+s+ RandomUtil.randomNumbers(5));
        int insert = mapper.saveUser(user);
        return insert>0;

    }
    @Override
    public User getById(String jobid) {
        return mapper.getByjobidUser(jobid);
    }

    @Override
    public boolean update(User user) {
        return mapper.updateById(user)>0;
    }

    @Override
    public Boolean deleteById(String jobid) {
        return mapper.deleteById(jobid)>0;
    }



    @Override
    public IPage<User> getPage(int currenPage, int pageSize, User warehous) {
        IPage page=new Page(currenPage,pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        String username = warehous.getUsername();
        String jobid = warehous.getJobid();
        String dename = warehous.getDename();
        Integer isValid = warehous.getIsValid();
        if (!StringUtils.isEmpty(username)){
            wrapper.like("u.username",username);
        }
        if (!StringUtils.isEmpty(jobid)){
            wrapper.like("u.jobid",jobid);
        }
        if (!StringUtils.isEmpty(dename)){
            wrapper.like("d.dename",dename);
        }
        if (!StringUtils.isEmpty(isValid)){
            wrapper.like("u.is_valid",isValid);
        }
        mapper.findByPage(page,wrapper);
        return page;
    }

    @Override
    public Boolean updateIsValidById(String jobid, Integer isValid) {
        return null;
    }


    @Override
    public Boolean checkAcname(String genrecode) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("genrecode",genrecode);
        User scrap = mapper.selectOne(wrapper);
        return scrap!=null;
    }



}

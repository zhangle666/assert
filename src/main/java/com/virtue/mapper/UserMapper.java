package com.virtue.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.virtue.pojo.User;
import com.virtue.pojo.Warehous;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    IPage<User> findByPage(IPage<User> page, @Param(Constants.WRAPPER) QueryWrapper<User> wrapper);

    Warehous findOneByjobid(String jobid);

    Integer saveUser(User user);

    User getByjobidUser(String jobid);


}

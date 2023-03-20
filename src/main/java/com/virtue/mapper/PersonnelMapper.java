package com.virtue.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.virtue.pojo.Personnel;
import com.virtue.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface PersonnelMapper extends BaseMapper<Personnel> {

    IPage<Personnel> findByPage(IPage<Personnel> page, @Param(Constants.WRAPPER) QueryWrapper<Personnel> wrapper);

}

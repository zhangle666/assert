package com.virtue.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.virtue.pojo.Borrowed;
import com.virtue.pojo.Retirement;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RetirementMapper extends BaseMapper<Retirement> {

    IPage<Retirement> findByPage(IPage<Retirement> page, @Param(Constants.WRAPPER) QueryWrapper<Retirement> wrapper);

     Retirement findOneByReid(Integer reid);

      Integer updateruturndate(Retirement retirement);
     Integer updateIsvalid(Integer reid);
        List<Retirement> findAll();
//        @Select("select * from borrowed where reid=#{reid}")
//        Retirement selectWaidByBoid(Integer reid);

}

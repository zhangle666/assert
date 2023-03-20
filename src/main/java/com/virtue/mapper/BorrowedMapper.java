package com.virtue.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.virtue.pojo.Borrowed;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BorrowedMapper extends BaseMapper<Borrowed> {

    IPage<Borrowed> findByPage(IPage<Borrowed> page, @Param(Constants.WRAPPER) QueryWrapper<Borrowed> wrapper);

   Borrowed findOneBySuid(Integer boid);

  Integer updateruturndate(Borrowed borrowed);

     List<Borrowed> findAll();
        @Select("select * from borrowed where boid=#{boid}")
       Borrowed selectWaidByBoid(Integer boid);

      Borrowed  selectByPeid(Integer peid);

}

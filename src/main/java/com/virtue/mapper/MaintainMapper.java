package com.virtue.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.virtue.pojo.Borrowed;
import com.virtue.pojo.Maintain;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MaintainMapper extends BaseMapper<Maintain> {

    IPage<Maintain> findByPage(IPage<Maintain> page, @Param(Constants.WRAPPER) QueryWrapper<Maintain> wrapper);

    Maintain findOneByMaid(Integer maid);

  Integer updateruturndate(Maintain maintain);

     List<Maintain> findAll();
        @Select("select * from borrowed where boid=#{boid}")
        Maintain selectWaidByBoid(Integer boid);


}

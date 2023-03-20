package com.virtue.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.virtue.pojo.Personnel;
import com.virtue.pojo.Retirement;
import com.virtue.pojo.Subscribe;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SubscribeMapper extends BaseMapper<Subscribe> {

    IPage<Subscribe> findByPage(IPage<Subscribe> page, @Param(Constants.WRAPPER) QueryWrapper<Subscribe> wrapper);

   Subscribe findOneBySuid(Integer suid);
   Integer updateBysubscribe(Subscribe subscribe);
    @Select("update subscribe set is_valid=1 suorder=#{suorder} where suid=#{suid}")
   Integer updateIsvalidBySuId(@Param("suid") Integer suid);
    @Update("update subscribe set is_valid=0 ,auditres=#{auditres} where suid=#{suid} ")
    Integer updateIsvalidAndausBySuId(Subscribe subscribe);

}

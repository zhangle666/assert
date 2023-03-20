package com.virtue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.virtue.pojo.Brand;
import com.virtue.pojo.Genres;
import org.apache.ibatis.annotations.Update;


public interface BrandMapper extends BaseMapper<Brand> {
    @Update("update brand set is_valid=#{isValid} where brid=#{brid}")
    Boolean   updateIsValidById(Integer brid,Integer isValid);

}

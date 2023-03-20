package com.virtue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.virtue.pojo.Achieve;
import org.apache.ibatis.annotations.Update;

public interface AchieveMapper extends BaseMapper<Achieve> {
    @Update("update achieve set is_valid=#{isValid} where acid=#{acid}")
    Boolean   updateIsValidById(Integer acid,Integer isValid);
}

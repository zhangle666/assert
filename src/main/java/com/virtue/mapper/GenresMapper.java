package com.virtue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.virtue.pojo.Genres;
import org.apache.ibatis.annotations.Update;


public interface GenresMapper extends BaseMapper<Genres> {
    @Update("update genre set is_valid=#{isValid} where gid=#{gid}")
    Boolean   updateIsValidById(Integer gid,Integer isValid);

}

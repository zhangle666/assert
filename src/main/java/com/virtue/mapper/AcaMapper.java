package com.virtue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.virtue.pojo.Aca;
import com.virtue.pojo.Genres;
import org.apache.ibatis.annotations.Update;


public interface AcaMapper extends BaseMapper<Aca> {
    @Update("update genre set is_valid=#{isValid} where gid=#{gid}")
    Boolean   updateIsValidById(Integer gid,Integer isValid);

}

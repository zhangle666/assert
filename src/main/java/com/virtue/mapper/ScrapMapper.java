package com.virtue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.virtue.pojo.Scrap;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ScrapMapper extends BaseMapper<Scrap> {
    @Update("update scrap set is_valid=#{isValid} where scid=#{scid}")
    Boolean   updateIsValidById(Integer scid,Integer isValid);

    @Select("select * from scrap where scnubs=#{scnubs} or scnames=#{scnames}")
    List<Scrap> selectByScnubsORScnames(Scrap scrap);

}

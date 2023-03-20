package com.virtue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.virtue.pojo.Supplier;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SupplierMapper extends BaseMapper<Supplier> {
    @Update("update supplier set is_valid=#{isValid} where supid=#{supid}")
    Boolean   updateIsValidById(Integer supid,Integer isValid);
    @Select("select * from supplier where supname=#{supname}")
   Supplier selectBySupname(String supname);
}

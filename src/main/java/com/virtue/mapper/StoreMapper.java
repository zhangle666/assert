package com.virtue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.virtue.pojo.Store;
import com.virtue.pojo.Supplier;
import org.apache.ibatis.annotations.Update;

public interface StoreMapper extends BaseMapper<Store> {
    @Update("update store set is_valid=#{isValid} where supid=#{supid}")
    Boolean   updateIsValidById(Integer supid,Integer isValid);

}

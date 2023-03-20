package com.virtue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.virtue.pojo.Department;
import org.apache.ibatis.annotations.Update;

public interface DepartmentMapper extends BaseMapper<Department> {
    @Update("update department set is_valid=#{isValid} where deid=#{deid}")
    Boolean   updateIsValidById(Integer deid,Integer isValid);

}

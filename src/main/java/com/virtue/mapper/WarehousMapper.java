package com.virtue.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.virtue.pojo.Retirement;
import com.virtue.pojo.Subscribe;
import com.virtue.pojo.Warehous;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WarehousMapper extends BaseMapper<Warehous> {

    IPage<Warehous> findByPage(IPage<Warehous> page, @Param(Constants.WRAPPER) QueryWrapper<Warehous> wrapper);

   Warehous findOneBySuid(Integer waid);

   Integer saveWarehous(Warehous warehous);

   Warehous getByWaidWarehous(Integer waid);
    List<Warehous>    findWaname();
    List<Warehous> findAll();
  Integer  updateIsValidByWaid(Integer waid);

  Warehous selectByWaname(String waname);
}

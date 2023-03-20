package com.virtue.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.virtue.pojo.Borrowed;
import com.virtue.pojo.Transfer;
import org.apache.ibatis.annotations.Param;

public interface TransferMapper extends BaseMapper<Transfer> {

    IPage<Transfer> findByPage(IPage<Transfer> page, @Param(Constants.WRAPPER) QueryWrapper<Transfer> wrapper);

    Transfer findOneByTrid(Integer trid);

  Integer updateruturndate(Transfer transfer);

}

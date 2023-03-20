package com.virtue.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.virtue.mapper.MaintainMapper;
import com.virtue.mapper.MaintainwxMapper;
import com.virtue.pojo.Maintain;
import com.virtue.pojo.Maintainwx;
import com.virtue.service.MaintainwxService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MaintainServicewxImpl implements MaintainwxService {
    @Resource
    private MaintainwxMapper mapper;




    @Override
    public IPage<Maintainwx> getPage(int currenPage, int pageSize, Maintainwx maintainwx) {
        IPage page=new Page(currenPage,pageSize);
        mapper.findByPage(page,null);
        return page;
    }




}

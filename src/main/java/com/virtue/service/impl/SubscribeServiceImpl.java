package com.virtue.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.virtue.mapper.PersonnelMapper;
import com.virtue.mapper.SubscribeMapper;
import com.virtue.pojo.Personnel;
import com.virtue.pojo.Retirement;
import com.virtue.pojo.Subscribe;
import com.virtue.service.PersonnelService;
import com.virtue.service.SubscribeService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SubscribeServiceImpl implements SubscribeService {
    @Resource
    private SubscribeMapper mapper;

    @Override
    public List<Subscribe> findAll() {

        return mapper.selectList(null);
    }

    @Override
    public Boolean save(Subscribe subscribe) {
        DateFormat format=new SimpleDateFormat("yyyyMMdd");
        String s=format.format(new Date());
        subscribe.setSuorder("SG"+s+ RandomUtil.randomNumbers(5));
        subscribe.setIsValid(2);
            int insert = mapper.insert(subscribe);
            return insert>0;

    }
    @Override
    public Subscribe getById(Integer suid) {
        return mapper.findOneBySuid(suid);
    }

    @Override
    public boolean update(Subscribe subscribe) {
        return mapper.updateBysubscribe(subscribe)>0;
    }

    @Override
    public Boolean deleteById(Integer suid) {
        return mapper.deleteById(suid)>0;
    }



    @Override
    public IPage<Subscribe> getPage(int currenPage, int pageSize, Subscribe subscribe) {
        IPage page=new Page(currenPage,pageSize);
        QueryWrapper<Subscribe> wrapper = new QueryWrapper<>();
        String genrecode = subscribe.getGenrecode();
        String pename = subscribe.getPename();
        String suorder = subscribe.getSuorder();
        if (!StringUtils.isEmpty(pename)){
            wrapper.like("s.pename",pename);
        }
        if (!StringUtils.isEmpty(genrecode)){
            wrapper.like("s.genrecode",genrecode);
        }
        if (!StringUtils.isEmpty(suorder)){
            wrapper.like("s.suorder",suorder);
        }
        mapper.findByPage(page,wrapper);
        return page;
    }


    @Override
    public Boolean checkAcname(String genrecode) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("genrecode",genrecode);
        Subscribe scrap = mapper.selectOne(wrapper);
        return scrap!=null;
    }

    @Override
    public Boolean updateIsvalidBySuId(Integer suid) {


            return mapper.updateIsvalidBySuId(suid)>0;
        }

    @Override
    public Boolean updateIsvalidAndausBySuId(Subscribe subscribe) {
        return mapper.updateIsvalidAndausBySuId(subscribe)>0;
    }


}

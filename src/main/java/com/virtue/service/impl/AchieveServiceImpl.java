package com.virtue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.virtue.mapper.AchieveMapper;
import com.virtue.pojo.Achieve;
import com.virtue.service.AchieveService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.util.List;

@Service
public class AchieveServiceImpl implements AchieveService {
    @Resource
    private AchieveMapper mapper;
    @Override
    public List<Achieve> findAll() {
        QueryWrapper<Achieve> wrapper = new QueryWrapper<>();
        wrapper.eq("is_valid",1);
        return mapper.selectList(wrapper);
    }

    @Override
    public Boolean save(Achieve achieve) {
            int insert = mapper.insert(achieve);
            return insert>0;
    }
    @Override
    public Achieve getById(Integer acid) {
        return mapper.selectById(acid);
    }

    @Override
    public boolean update(Achieve achieve) {
        return mapper.updateById(achieve)>0;
    }

    @Override
    public Boolean deleteById(String acid) {
        return mapper.deleteById(acid)>0;
    }



    @Override
    public IPage<Achieve> getPage(int currenPage, int pageSize, Achieve achieve) {
        IPage page=new Page(currenPage,pageSize);
        QueryWrapper<Achieve> wrapper = new QueryWrapper<>();
        String acnub = achieve.getAcnub();
        String acname = achieve.getAcname();
        Integer isValid = achieve.getIsValid();
        if (!StringUtils.isEmpty(isValid)){
            wrapper.like("is_valid",isValid);
        }
        if (!StringUtils.isEmpty(acname)){
            wrapper.like("brname",acname);
        }
        if (!StringUtils.isEmpty(acnub)){
            wrapper.like("acnub",acnub);
        }
        mapper.selectPage(page,wrapper);
        return page;
    }

    @Override
    public Boolean updateIsValidById(Integer acid, Integer isValid) {
        return mapper.updateIsValidById(acid,isValid);
    }

    @Override
    public Boolean checkAcname(String genrecode) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("genrecode",genrecode);
        Achieve achieve = mapper.selectOne(wrapper);
        return achieve!=null;
    }
}

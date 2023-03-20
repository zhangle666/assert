package com.virtue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.virtue.mapper.AcaMapper;
import com.virtue.mapper.AcaMapper;
import com.virtue.pojo.Aca;
import com.virtue.service.AcaService;
import com.virtue.service.AcaService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AcaServiceImpl implements AcaService {
    @Resource
    private AcaMapper mapper;
    @Override
    public List<Aca> findAll() {
        QueryWrapper<Aca> wrapper=new QueryWrapper<>();
        wrapper.eq("is_valid",1);
        return mapper.selectList(wrapper);
    }

    @Override
    public Boolean save(Aca aca) {
            int insert = mapper.insert(aca);
            return insert>0;


    }
    @Override
    public Aca getById(Integer adid) {
        return mapper.selectById(adid);
    }

    @Override
    public boolean update(Aca aca) {
        return mapper.updateById(aca)>0;
    }

    @Override
    public Boolean deleteById(String adid) {
        return mapper.deleteById(adid)>0;
    }

    @Override
    public IPage<Aca> getPage(int currenPage, int pageSize,Aca aca) {
        IPage page=new Page(currenPage,pageSize);
        QueryWrapper<Aca> wrapper = new QueryWrapper<>();

        String adorder = aca.getAdorder();

        if (!StringUtils.isEmpty(adorder)){
            wrapper.like("adorder",adorder);
        }
        mapper.selectPage(page,wrapper);
        return page;
    }


    @Override
    public Boolean checkGenrecode(String genrecode) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("genrecode",genrecode);
        Aca aca = mapper.selectOne(wrapper);
        return aca!=null;
    }
}

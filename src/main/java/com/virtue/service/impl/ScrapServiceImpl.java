package com.virtue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.virtue.mapper.ScrapMapper;
import com.virtue.pojo.Scrap;
import com.virtue.service.ScrapService;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ScrapServiceImpl implements ScrapService {
    @Resource
    private ScrapMapper mapper;
    @Override
    public List<Scrap> findAll() {
        QueryWrapper<Scrap> wrapper = new QueryWrapper<>();
        wrapper.eq("is_valid",1);
        return mapper.selectList(null);
    }

    @Override
    public Boolean save(Scrap scrap) {
        try {
            String scnubs = scrap.getScnubs();
            String scnames = scrap.getScnames();
            List<Scrap> scrap1 = mapper.selectByScnubsORScnames(scrap);
            if (scrap1.size()>1){
                return false;
            }
            if (scrap1==null){
                int insert = mapper.insert(scrap);
                return insert>0;
            }
        }catch (TooManyResultsException e){
            return false;

        }


       return false;

    }
    @Override
    public Scrap getById(Integer scid) {
        return mapper.selectById(scid);
    }

    @Override
    public boolean update(Scrap scrap) {
        List<Scrap> scrap1 = mapper.selectByScnubsORScnames(scrap);
        if (scrap1.size()>1){
            return false;
        }
        if (scrap1==null){
            return mapper.updateById(scrap)>0;
        }
       return false;
    }

    @Override
    public Boolean deleteById(String scid) {
        return mapper.deleteById(scid)>0;
    }



    @Override
    public IPage<Scrap> getPage(int currenPage, int pageSize, Scrap scrap) {
        IPage page=new Page(currenPage,pageSize);
        QueryWrapper<Scrap> wrapper = new QueryWrapper<>();
        String scnubs = scrap.getScnubs();
        String scnames = scrap.getScnames();
        Integer isValid = scrap.getIsValid();
        if (!StringUtils.isEmpty(isValid)){
            wrapper.like("is_valid",isValid);
        }
        if (!StringUtils.isEmpty(scnames)){
            wrapper.like("scnames",scnames);
        }
        if (!StringUtils.isEmpty(scnubs)){
            wrapper.like("scnubs",scnubs);
        }
        mapper.selectPage(page,wrapper);
        return page;
    }

    @Override
    public Boolean updateIsValidById(Integer scid, Integer isValid) {
        return mapper.updateIsValidById(scid,isValid);
    }

    @Override
    public Boolean checkAcname(String genrecode) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("genrecode",genrecode);
        Scrap scrap = mapper.selectOne(wrapper);
        return scrap!=null;
    }
}

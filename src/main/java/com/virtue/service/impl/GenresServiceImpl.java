package com.virtue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.virtue.mapper.GenresMapper;
import com.virtue.pojo.Genres;
import com.virtue.service.GenresService;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import javax.annotation.Resource;
import java.util.List;
@Service
public class GenresServiceImpl implements GenresService {
    @Resource
    private GenresMapper genresMapper;
    @Override
    public List<Genres> findAll() {
        QueryWrapper<Genres> wrapper=new QueryWrapper<>();
        wrapper.eq("is_valid",1);
        return genresMapper.selectList(wrapper);
    }

    @Override
    public Boolean save(Genres genres) {
            int insert = genresMapper.insert(genres);
            return insert>0;


    }
    @Override
    public Genres getById(Integer gid) {
        return genresMapper.selectById(gid);
    }

    @Override
    public boolean update(Genres genres) {
        return genresMapper.updateById(genres)>0;
    }

    @Override
    public Boolean deleteById(String gid) {
        return genresMapper.deleteById(gid)>0;
    }

    @Override
    public IPage<Genres> getPage(int currenPage, int pageSize,Genres genres) {
        IPage page=new Page(currenPage,pageSize);
        QueryWrapper<Genres> wrapper = new QueryWrapper<>();
        Integer isValid = genres.getIsValid();
        String gname = genres.getGname();
        String genrecode = genres.getGenrecode();
        if (!StringUtils.isEmpty(isValid)){
            wrapper.like("is_valid",isValid);
        }
        if (!StringUtils.isEmpty(gname)){
            wrapper.like("gname",gname);
        }
        if (!StringUtils.isEmpty(genrecode)){
            wrapper.like("genrecode",genrecode);
        }
        genresMapper.selectPage(page,wrapper);
        return page;
    }

    @Override
    public Boolean updateIsValidById(Integer gid, Integer isValid) {
        return genresMapper.updateIsValidById(gid,isValid);
    }

    @Override
    public Boolean checkGenrecode(String genrecode) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("genrecode",genrecode);
        Genres genres = genresMapper.selectOne(wrapper);
        return genres!=null;
    }
}

package com.virtue.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.pojo.Genres;
import java.util.List;
public interface GenresService {

    List<Genres> findAll();

    Boolean save(Genres genres);

    Genres getById(Integer gid);

    boolean update(Genres genres);
    Boolean deleteById(String gid);
    IPage<Genres> getPage(int currenPage, int pageSize,Genres genres);

    Boolean   updateIsValidById(Integer gid,Integer isValid);
    Boolean checkGenrecode(String genrecode);

}

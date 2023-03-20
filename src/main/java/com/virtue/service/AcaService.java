package com.virtue.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.pojo.Aca;

import java.util.List;

public interface AcaService {

    List<Aca> findAll();

    Boolean save(Aca aca);

    Aca getById(Integer adid);

    boolean update(Aca aca);
    Boolean deleteById(String adid);
    IPage<Aca> getPage(int currenPage, int pageSize,Aca aca);
    
    Boolean checkGenrecode(String genrecode);

}

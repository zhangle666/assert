package com.virtue.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.model.ReturnParam;
import com.virtue.pojo.Achieve;
import com.virtue.pojo.Genres;
import com.virtue.service.GenresService;

import com.virtue.service.impl.GenresServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/genres")
public class GenresController {
    @Autowired
    private GenresServiceImpl genresService;
    @GetMapping
    public ReturnParam findAll(){
      return new ReturnParam(genresService.findAll()) ;
    }
    @PostMapping("{currenPage}/{pageSize}")
    public ReturnParam toAssestGenre( @PathVariable int currenPage, @PathVariable int pageSize,@RequestBody Genres genres){
        System.out.println(genres);
        IPage<Genres> page = genresService.getPage(currenPage, pageSize,genres);
        if (currenPage>page.getPages()){
            page = genresService.getPage((int) page.getPages(), pageSize,genres);
        }
       return new ReturnParam(true,page) ;
    }
    @GetMapping("{gid}")
    @ResponseBody
    public ReturnParam getById(@PathVariable Integer gid){
        Genres genre = genresService.getById(gid);
        if (genre!=null){
            return new ReturnParam(true,genre);
        }
        return new ReturnParam(false);

    }
    @PutMapping
    @ResponseBody
    public ReturnParam Update(@RequestBody Genres genres){
        return new ReturnParam(genresService.update(genres));

    }
    @DeleteMapping("{gid}")
    @ResponseBody
    public ReturnParam delete(@PathVariable String gid){
        return new ReturnParam(genresService.deleteById(gid));

    }

    @PutMapping("{gid}/{isValid}")
    @ResponseBody
    private ReturnParam updateIsValid(@PathVariable Integer gid,@PathVariable Integer isValid){

        return  new ReturnParam(genresService.updateIsValidById(gid,isValid));
    }

    @PostMapping
    @ResponseBody
    public ReturnParam save(@RequestBody Genres genres){
            try {

                return new ReturnParam(genresService.save(genres)) ;
            }catch (DuplicateKeyException e){
                return new ReturnParam(false,"资产类别或名称已经存在！") ;
            }

    }
    @PostMapping("/checkform")
    public ReturnParam checkForm(@RequestBody Genres genres){
        String genrecode = genres.getGenrecode();
        return new ReturnParam(genresService.checkGenrecode(genrecode),"已经存在");
    }

}

package com.virtue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.model.ReturnParam;
import com.virtue.pojo.Achieve;
import com.virtue.pojo.Brand;
import com.virtue.pojo.Genres;
import com.virtue.service.AchieveService;
import com.virtue.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/achieve")
public class AchieveController {
    @Autowired
    private AchieveService service;
    @GetMapping
    public ReturnParam getAllAchieve(){

        return new ReturnParam(service.findAll());
    }
    @PostMapping("{currenPage}/{pageSize}")
    public ReturnParam toAssestGenre( @PathVariable int currenPage, @PathVariable int pageSize,@RequestBody Achieve achieve){

        IPage<Achieve> page = service.getPage(currenPage, pageSize,achieve);
        if (currenPage>page.getPages()){
            page = service.getPage((int) page.getPages(), pageSize,achieve);
        }
        return new ReturnParam(true,page) ;
    }
    @GetMapping("{acid}")
    @ResponseBody
    public ReturnParam getById(@PathVariable Integer acid){
        Achieve achieve = service.getById(acid);
        if (achieve!=null){
            return new ReturnParam(true,achieve);
        }
        return new ReturnParam(false);

    }
    @PutMapping
    @ResponseBody
    public ReturnParam Update(@RequestBody Achieve achieve){
        return new ReturnParam(service.update(achieve));

    }
    @DeleteMapping("{acid}")
    @ResponseBody
    public ReturnParam delete(@PathVariable String acid){
        return new ReturnParam(service.deleteById(acid));

    }

    @PutMapping("{acid}/{isValid}")
    @ResponseBody
    private ReturnParam updateIsValid(@PathVariable Integer acid,@PathVariable Integer isValid){


        return  new ReturnParam(service.updateIsValidById(acid,isValid));
    }

    @PostMapping
    @ResponseBody
    public ReturnParam save(@RequestBody Achieve achieve){
        try {
            return new ReturnParam(service.save(achieve)) ;
        }catch (DuplicateKeyException e){
            return new ReturnParam(service.save(achieve),"删除失败！该名称已经存在") ;
        }

    }

}

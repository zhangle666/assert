package com.virtue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.model.ReturnParam;
import com.virtue.pojo.Scrap;
import com.virtue.service.ScrapService;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scrap")
public class ScrapController {
    @Autowired
    private ScrapService service;

    @GetMapping
    private ReturnParam findAll(){
        return new ReturnParam(service.findAll());

    }
    @PostMapping("{currenPage}/{pageSize}")
    public ReturnParam toAssestGenre( @PathVariable int currenPage, @PathVariable int pageSize,@RequestBody Scrap scrap){

        IPage<Scrap> page = service.getPage(currenPage, pageSize,scrap);
        if (currenPage>page.getPages()){
            page = service.getPage((int) page.getPages(), pageSize,scrap);
        }
        return new ReturnParam(true,page) ;
    }
    @GetMapping("{scid}")
    public ReturnParam getById(@PathVariable Integer scid){
            Scrap scrap = service.getById(scid);
            if (scrap!=null){
                return new ReturnParam(true,scrap);
            }
            return new ReturnParam(false,"修改失败！方式和编码都有重复！");


    }
    @PutMapping
    public ReturnParam Update(@RequestBody Scrap scrap){
       if (service.update(scrap)){

           return new ReturnParam(true);

       }
        return new ReturnParam(false,"保存失败！该上报方式或编码重复");
    }
    @DeleteMapping("{scid}")
    public ReturnParam delete(@PathVariable String scid){
        return new ReturnParam(service.deleteById(scid));

    }

    @PutMapping("{scid}/{isValid}")
    private ReturnParam updateIsValid(@PathVariable Integer scid,@PathVariable Integer isValid){


        return  new ReturnParam(service.updateIsValidById(scid,isValid));
    }

    @PostMapping
    public ReturnParam save(@RequestBody Scrap scrap){

            if (service.save(scrap)){
                return new ReturnParam(true) ;
            }else{
                return new ReturnParam(false,"保存失败！该上报方式或编码重复");
            }


    }
}

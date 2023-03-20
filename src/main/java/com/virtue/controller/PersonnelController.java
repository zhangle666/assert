package com.virtue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.model.ReturnParam;
import com.virtue.pojo.Personnel;
import com.virtue.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personnel")
public class PersonnelController {
    @Autowired
    private PersonnelService service;
    @GetMapping
        public ReturnParam findAll(){
        return new ReturnParam(service.findAll());
    }
    @PostMapping("{currenPage}/{pageSize}")
    public ReturnParam toAssestGenre( @PathVariable int currenPage, @PathVariable int pageSize,@RequestBody Personnel personnel){

        IPage<Personnel> page = service.getPage(currenPage, pageSize,personnel);
        if (currenPage>page.getPages()){
            page = service.getPage((int) page.getPages(), pageSize,personnel);
        }
        return new ReturnParam(true,page) ;
    }
    @GetMapping("{peid}")
    @ResponseBody
    public ReturnParam getById(@PathVariable Integer peid){
        Personnel personnel = service.getById(peid);
        if (personnel!=null){
            return new ReturnParam(true,personnel);
        }
        return new ReturnParam(false);

    }
    @PutMapping
    @ResponseBody
    public ReturnParam Update(@RequestBody Personnel personnel){
        return new ReturnParam(service.update(personnel));

    }
    @DeleteMapping("{peid}")
    @ResponseBody
    public ReturnParam delete(@PathVariable Integer peid){
        if (peid == null) {
            return new ReturnParam(false,"该员工不存在");

        }
       if (service.deleteById(peid)){
           return new ReturnParam(true);
       }
        return new ReturnParam(false,"该员工有未归还资产!,不可删除！");


    }

    @PostMapping
    @ResponseBody
    public ReturnParam save(@RequestBody Personnel personnel){

        try {
            Boolean saverow = service.save(personnel);
            return new ReturnParam(saverow);
        }catch (DuplicateKeyException e){
            return new ReturnParam(false,"添加失败！当前工号已经存在！");
        }
    }
}

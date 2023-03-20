package com.virtue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.model.ReturnParam;
import com.virtue.pojo.Supplier;
import com.virtue.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService service;

    @GetMapping
    public ReturnParam getAllSupplier(){

        return new ReturnParam(service.findAll());
    }
    @PostMapping("{currenPage}/{pageSize}")
    public ReturnParam toAssestGenre( @PathVariable int currenPage, @PathVariable int pageSize,@RequestBody Supplier supplier){

        IPage<Supplier> page = service.getPage(currenPage, pageSize,supplier);
        if (currenPage>page.getPages()){
            page = service.getPage((int) page.getPages(), pageSize,supplier);
        }
        return new ReturnParam(true,page) ;
    }
    @GetMapping("{supid}")
    @ResponseBody
    public ReturnParam getById(@PathVariable Integer supid){
        Supplier supplier = service.getById(supid);
        if (supplier!=null){
            return new ReturnParam(true,supplier);
        }
        return new ReturnParam(false);

    }
    @PutMapping
    @ResponseBody
    public ReturnParam Update(@RequestBody Supplier supplier){
        boolean b = service.update(supplier);
        if (b){
            return new ReturnParam(true);
        }
        return new ReturnParam(false,"修改失败！该名称已经存在");

    }
    @DeleteMapping("{supid}")
    @ResponseBody
    public ReturnParam delete(@PathVariable String supid){
        return new ReturnParam(service.deleteById(supid));

    }

    @PutMapping("{supid}/{isValid}")
    @ResponseBody
    private ReturnParam updateIsValid(@PathVariable Integer supid,@PathVariable Integer isValid){


        return  new ReturnParam(service.updateIsValidById(supid,isValid));
    }

    @PostMapping
    @ResponseBody
    public ReturnParam save(@RequestBody Supplier supplier){
        Boolean save = service.save(supplier);
        if (save){
            return new ReturnParam(true) ;
        }else {
            return new ReturnParam(false,"删除失败!该名称已经存在");
        }

    }
}

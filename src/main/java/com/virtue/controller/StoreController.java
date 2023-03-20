package com.virtue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.model.ReturnParam;
import com.virtue.pojo.Store;
import com.virtue.pojo.Supplier;
import com.virtue.service.StoreService;
import com.virtue.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService service;
        @GetMapping
        public ReturnParam getAllStore(){
            return new ReturnParam(service.findAll());
        }
    @PostMapping("{currenPage}/{pageSize}")
    public ReturnParam toAssestGenre( @PathVariable int currenPage, @PathVariable int pageSize,@RequestBody Store store){

        IPage<Store> page = service.getPage(currenPage, pageSize,store);
        if (currenPage>page.getPages()){
            page = service.getPage((int) page.getPages(), pageSize,store);
        }
        return new ReturnParam(true,page) ;
    }
    @GetMapping("{stid}")
    @ResponseBody
    public ReturnParam getById(@PathVariable Integer stid){
        Store store = service.getById(stid);
        if (store!=null){
            return new ReturnParam(true,store);
        }
        return new ReturnParam(false);

    }
    @PutMapping
    @ResponseBody
    public ReturnParam Update(@RequestBody Store store){
        return new ReturnParam(service.update(store));

    }
    @DeleteMapping("{stid}")
    @ResponseBody
    public ReturnParam delete(@PathVariable String stid){
        return new ReturnParam(service.deleteById(stid));

    }

    @PutMapping("{stid}/{isValid}")
    @ResponseBody
    private ReturnParam updateIsValid(@PathVariable Integer stid,@PathVariable Integer isValid){


        return  new ReturnParam(service.updateIsValidById(stid,isValid));
    }

    @PostMapping
    @ResponseBody
    public ReturnParam save(@RequestBody Store store){

        return new ReturnParam(service.save(store)) ;
    }
}

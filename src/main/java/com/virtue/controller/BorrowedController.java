package com.virtue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.model.ReturnParam;
import com.virtue.pojo.Borrowed;
import com.virtue.pojo.Subscribe;
import com.virtue.service.BorrowedService;
import com.virtue.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrowed")
public class BorrowedController {
    @Autowired
    private BorrowedService service;


    @GetMapping
    private ReturnParam findAll(){

        return new ReturnParam(service.findAll());
    }
    @PostMapping("{currenPage}/{pageSize}")
    public ReturnParam toAssestGenre( @PathVariable int currenPage, @PathVariable int pageSize,@RequestBody Borrowed borrowed){
        IPage<Borrowed> page = service.getPage(currenPage, pageSize,borrowed);
        if (currenPage>page.getPages()){
            page = service.getPage((int) page.getPages(), pageSize,borrowed);
        }
        return new ReturnParam(true,page) ;
    }
    @GetMapping("{boid}")
    @ResponseBody
    public ReturnParam getById(@PathVariable Integer boid){
        Borrowed borrowed = service.getById(boid);
        if (borrowed!=null){
            return new ReturnParam(true,borrowed);
        }
        return new ReturnParam(false);

    }
    @PutMapping
    @ResponseBody
    public ReturnParam Update(@RequestBody Borrowed borrowed){
        return new ReturnParam(service.update(borrowed));

    }
    @DeleteMapping("{boid}")
    @ResponseBody
    public ReturnParam delete(@PathVariable Integer boid){
        return new ReturnParam(service.deleteById(boid));

    }

    @PostMapping
    @ResponseBody
    public ReturnParam save(@RequestBody Borrowed borrowed){
        System.out.println(borrowed);
        return new ReturnParam(service.save(borrowed)) ;
    }
}

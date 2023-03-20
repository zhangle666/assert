package com.virtue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.model.ReturnParam;
import com.virtue.pojo.Maintain;
import com.virtue.service.BorrowedService;
import com.virtue.service.MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maintain")
public class MaintainController {
    @Autowired
    private MaintainService service;
    @GetMapping
    private ReturnParam findAll(){

        return new ReturnParam(service.findAll());
    }
    @PostMapping("{currenPage}/{pageSize}")
    public ReturnParam toAssestGenre( @PathVariable int currenPage, @PathVariable int pageSize,@RequestBody Maintain maintain){
        IPage<Maintain> page = service.getPage(currenPage, pageSize,maintain);
        if (currenPage>page.getPages()){
            page = service.getPage((int) page.getPages(), pageSize,maintain);
        }
        return new ReturnParam(true,page) ;
    }
    @GetMapping("{maid}")
    @ResponseBody
    public ReturnParam getById(@PathVariable Integer maid){
        Maintain maintain = service.getById(maid);
        if (maintain!=null){
            return new ReturnParam(true,maintain);
        }
        return new ReturnParam(false);

    }
    @PutMapping
    @ResponseBody
    public ReturnParam Update(@RequestBody Maintain maintain){
        return new ReturnParam(service.update(maintain));

    }
    @DeleteMapping("{maid}")
    @ResponseBody
    public ReturnParam delete(@PathVariable Integer maid){
        return new ReturnParam(service.deleteById(maid));

    }

    @PostMapping
    @ResponseBody
    public ReturnParam save(@RequestBody Maintain maintain){
        System.out.println(maintain);
        return new ReturnParam(service.save(maintain)) ;
    }
}

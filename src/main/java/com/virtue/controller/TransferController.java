package com.virtue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.model.ReturnParam;
import com.virtue.pojo.Transfer;
import com.virtue.service.BorrowedService;
import com.virtue.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfer")
public class TransferController {
    @Autowired
    private TransferService service;

    @PostMapping("{currenPage}/{pageSize}")
    public ReturnParam toAssestGenre( @PathVariable int currenPage, @PathVariable int pageSize,@RequestBody Transfer transfer){
        IPage<Transfer> page = service.getPage(currenPage, pageSize,transfer);
        if (currenPage>page.getPages()){
            page = service.getPage((int) page.getPages(), pageSize,transfer);
        }
        return new ReturnParam(true,page) ;
    }
    @GetMapping("{trid}")
    @ResponseBody
    public ReturnParam getById(@PathVariable Integer trid){
        Transfer Transfer = service.getById(trid);
        if (Transfer!=null){
            return new ReturnParam(true,Transfer);
        }
        return new ReturnParam(false);

    }
    @PutMapping
    @ResponseBody
    public ReturnParam Update(@RequestBody Transfer transfer){
        return new ReturnParam(service.update(transfer));

    }
    @DeleteMapping("{trid}")
    @ResponseBody
    public ReturnParam delete(@PathVariable Integer trid){
        return new ReturnParam(service.deleteById(trid));

    }

    @PostMapping
    @ResponseBody
    public ReturnParam save(@RequestBody Transfer transfer){
        System.out.println(true);
        return new ReturnParam(service.save(transfer)) ;
    }
}

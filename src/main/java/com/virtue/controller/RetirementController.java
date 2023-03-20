package com.virtue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.model.ReturnParam;
import com.virtue.pojo.Retirement;
import com.virtue.service.RetirementService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/retirement")
public class RetirementController {
    @Autowired
    private RetirementService service;


    @GetMapping("/downloadAllRetirement")
    private void findAll(HttpServletResponse response){
       service.downloadAllRetirement(response);
    }
    @PostMapping("{currenPage}/{pageSize}")
    public ReturnParam toAssestGenre( @PathVariable int currenPage, @PathVariable int pageSize,@RequestBody Retirement retirement){
        IPage<Retirement> page = service.getPage(currenPage, pageSize,retirement);
        if (currenPage>page.getPages()){
            page = service.getPage((int) page.getPages(), pageSize,retirement);
        }
        return new ReturnParam(true,page) ;
    }
    @GetMapping("{reid}")

    public ReturnParam getById(@PathVariable Integer reid){
        Retirement retirement = service.getById(reid);
        if (retirement!=null){
            return new ReturnParam(true,retirement);
        }
        return new ReturnParam(false);

    }
    @PutMapping

    public ReturnParam Update(@RequestBody Retirement retirement){
        return new ReturnParam(service.update(retirement));

    }
    @DeleteMapping("{reid}")

    public ReturnParam delete(@PathVariable Integer reid){
        return new ReturnParam(service.deleteById(reid));

    }

    @PostMapping

    public ReturnParam save(@RequestBody Retirement retirement){
        System.out.println(retirement);
        return new ReturnParam(service.save(retirement)) ;
    }
    @PutMapping("{reid}")

    public ReturnParam updateIsvalid(@PathVariable Integer reid){

        return new ReturnParam(service.updateIsvalid(reid));
    }

}

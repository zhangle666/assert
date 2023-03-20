package com.virtue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.model.ReturnParam;
import com.virtue.pojo.Personnel;
import com.virtue.pojo.Retirement;
import com.virtue.pojo.Subscribe;
import com.virtue.service.PersonnelService;
import com.virtue.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscribe")
public class SubscribeController {
    @Autowired
    private SubscribeService service;

    @PostMapping("{currenPage}/{pageSize}")
    public ReturnParam toAssestGenre( @PathVariable int currenPage, @PathVariable int pageSize,@RequestBody Subscribe subscribe){
        IPage<Subscribe> page = service.getPage(currenPage, pageSize,subscribe);
        if (currenPage>page.getPages()){
            page = service.getPage((int) page.getPages(), pageSize,subscribe);
        }
        return new ReturnParam(true,page) ;
    }
    @GetMapping("{suid}")
    @ResponseBody
    public ReturnParam getById(@PathVariable Integer suid){
        Subscribe subscribe = service.getById(suid);
        if (subscribe!=null){
            return new ReturnParam(true,subscribe);
        }
        return new ReturnParam(false);

    }
    @PutMapping
    @ResponseBody
    public ReturnParam Update(@RequestBody Subscribe subscribe){
        System.out.println(subscribe);
        subscribe.setGenrecode("");
        System.out.println(subscribe.getGenrecode()+"122222222222222222222222");
        return new ReturnParam(service.update(subscribe));
//        return null;

    }
    @DeleteMapping("{suid}")
    @ResponseBody
    public ReturnParam delete(@PathVariable Integer suid){
        return new ReturnParam(service.deleteById(suid));

    }

    @PostMapping
    @ResponseBody
    public ReturnParam save(@RequestBody Subscribe subscribe){

            return new ReturnParam(service.save(subscribe)) ;

    }
    @PutMapping("{suid}")
    public ReturnParam updateIsvalidBySuId(@PathVariable Integer suid){
        try {
            return new ReturnParam(service.updateIsvalidBySuId(suid));
        }catch (NullPointerException e){
            return new ReturnParam(true);
        }

    }
    @PutMapping("/disagree")
    public ReturnParam updateIsvalidAndausBySuId(@RequestBody Subscribe subscribe){
        System.out.println(subscribe);

        return new ReturnParam(service.updateIsvalidAndausBySuId(subscribe));
    }

}

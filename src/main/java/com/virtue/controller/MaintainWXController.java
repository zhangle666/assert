package com.virtue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.model.ReturnParam;
import com.virtue.pojo.Maintain;
import com.virtue.pojo.Maintainwx;
import com.virtue.service.MaintainService;
import com.virtue.service.MaintainwxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maintainwx")
public class MaintainWXController {
    @Autowired
    private MaintainwxService service;
    @PostMapping("{currenPage}/{pageSize}")
    public ReturnParam toAssestGenre( @PathVariable int currenPage, @PathVariable int pageSize,@RequestBody Maintainwx maintainwx){
        IPage<Maintainwx> page = service.getPage(currenPage, pageSize,maintainwx);
        if (currenPage>page.getPages()){
            page = service.getPage((int) page.getPages(), pageSize,maintainwx);
        }
        return new ReturnParam(true,page) ;
    }

}

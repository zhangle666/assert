package com.virtue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.model.ReturnParam;
import com.virtue.pojo.Scrap;
import com.virtue.pojo.User;
import com.virtue.pojo.UserDept;
import com.virtue.service.ScrapService;
import com.virtue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userMa")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("{currenPage}/{pageSize}")
    public ReturnParam toAssestGenre( @PathVariable int currenPage, @PathVariable int pageSize,@RequestBody User user){

        IPage<User> page = service.getPage(currenPage, pageSize,user);
        if (currenPage>page.getPages()){
            page = service.getPage((int) page.getPages(), pageSize,user);
        }
        return new ReturnParam(true,page) ;
    }
    @GetMapping("{jobid}")
    @ResponseBody
    public ReturnParam getById(@PathVariable String jobid){
        User user = service.getById(jobid);
        if (user!=null){
            return new ReturnParam(true,user);
        }
        return new ReturnParam(false);

    }
    @PutMapping
    @ResponseBody
    public ReturnParam Update(@RequestBody User user){
        return new ReturnParam(service.update(user));

    }
    @DeleteMapping("{jobid}")
    @ResponseBody
    public ReturnParam delete(@PathVariable String jobid){
        return new ReturnParam(service.deleteById(jobid));

    }

    @PutMapping("{jobid}/{isValid}")
    @ResponseBody
    private ReturnParam updateIsValid(@PathVariable String jobid,@PathVariable Integer isValid){


        return  new ReturnParam(service.updateIsValidById(jobid,isValid));
    }

    @PostMapping
    @ResponseBody
    public ReturnParam save(@RequestBody User user){

        return new ReturnParam(service.save(user)) ;
    }
}

package com.virtue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.model.ReturnParam;
import com.virtue.pojo.Department;
import com.virtue.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.DuplicateKeyException;
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService service;
      @GetMapping
    public ReturnParam finAll(){
        return new ReturnParam(service.findAll());
    }
    @PostMapping("{currenPage}/{pageSize}")
    public ReturnParam toAssestGenre( @PathVariable int currenPage, @PathVariable int pageSize,@RequestBody Department department){

        IPage<Department> page = service.getPage(currenPage, pageSize,department);
        if (currenPage>page.getPages()){
            page = service.getPage((int) page.getPages(), pageSize,department);
        }
        return new ReturnParam(true,page) ;
    }
    @GetMapping("{deid}")
    @ResponseBody
    public ReturnParam getById(@PathVariable Integer deid){
              Department department = service.getById(deid);
        if (department!=null){
            return new ReturnParam(true,department);
        }
        return new ReturnParam(false);

    }
    @PutMapping
    @ResponseBody
    public ReturnParam Update(@RequestBody Department department){
        return new ReturnParam(service.update(department));
    }
    @DeleteMapping("{deid}")
    @ResponseBody
    public ReturnParam delete(@PathVariable String deid){
        return new ReturnParam(service.deleteById(deid));
    }

    @PutMapping("{deid}/{isValid}")
    @ResponseBody
    private ReturnParam updateIsValid(@PathVariable Integer deid,@PathVariable Integer isValid){
        return  new ReturnParam(service.updateIsValidById(deid,isValid));
    }

    @PostMapping
    @ResponseBody
    public ReturnParam save(@RequestBody Department department){
          try {
        Boolean saverow = service.save(department);
        return new ReturnParam(saverow);
    }catch (DuplicateKeyException e){
        return new ReturnParam(false,"当前部门编码或名称存在！");
    }


    }
}

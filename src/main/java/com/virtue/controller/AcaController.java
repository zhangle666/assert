package com.virtue.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.model.ReturnParam;
import com.virtue.pojo.Aca;
import com.virtue.service.impl.AcaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/aca")
public class AcaController {
    @Autowired
    private AcaServiceImpl acaService;
    @GetMapping
    public ReturnParam findAll(){
      return new ReturnParam(acaService.findAll()) ;
    }
    @PostMapping("{currenPage}/{pageSize}")
    public ReturnParam toAssestGenre( @PathVariable int currenPage, @PathVariable int pageSize,@RequestBody Aca aca){
        System.out.println(aca);
        IPage<Aca> page = acaService.getPage(currenPage, pageSize,aca);
        if (currenPage>page.getPages()){
            page = acaService.getPage((int) page.getPages(), pageSize,aca);
        }
       return new ReturnParam(true,page) ;
    }
    @GetMapping("{adid}")
    @ResponseBody
    public ReturnParam getById(@PathVariable Integer adid){
        Aca genre = acaService.getById(adid);
        if (genre!=null){
            return new ReturnParam(true,genre);
        }
        return new ReturnParam(false);

    }
    @PutMapping
    @ResponseBody
    public ReturnParam Update(@RequestBody Aca aca){
        return new ReturnParam(acaService.update(aca));

    }
    @DeleteMapping("{adid}")
    @ResponseBody
    public ReturnParam delete(@PathVariable String adid){
        return new ReturnParam(acaService.deleteById(adid));

    }



    @PostMapping
    @ResponseBody
    public ReturnParam save(@RequestBody Aca aca){
            try {

                return new ReturnParam(acaService.save(aca)) ;
            }catch (DuplicateKeyException e){
                return new ReturnParam(false,"资产类别或名称已经存在！") ;
            }

    }
 
}

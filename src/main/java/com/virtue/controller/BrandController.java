package com.virtue.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.model.ReturnParam;
import com.virtue.pojo.Brand;
import com.virtue.pojo.Genres;
import com.virtue.service.BrandService;
import com.virtue.service.impl.GenresServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/brand")
public class BrandController {


    @Autowired
    private BrandService brandService;
    @GetMapping
    public ReturnParam getAllBrand(){

        return new ReturnParam(brandService.findAll());

    }
    @PostMapping("{currenPage}/{pageSize}")
    public ReturnParam toAssestGenre( @PathVariable int currenPage, @PathVariable int pageSize,@RequestBody Brand brand){
        System.out.println(brand+"1111111111111111");
        IPage<Brand> page = brandService.getPage(currenPage, pageSize,brand);
        if (currenPage>page.getPages()){
            page = brandService.getPage((int) page.getPages(), pageSize,brand);
        }
       return new ReturnParam(true,page) ;
    }
    @GetMapping("{brid}")
    @ResponseBody
    public ReturnParam getById(@PathVariable Integer brid){
        Brand brand = brandService.getById(brid);
        if (brand!=null){
            return new ReturnParam(true,brand);
        }
        return new ReturnParam(false);

    }
    @PutMapping
    @ResponseBody
    public ReturnParam Update(@RequestBody Brand brand){
        return new ReturnParam(brandService.update(brand));

    }
    @DeleteMapping("{brid}")
    @ResponseBody
    public ReturnParam delete(@PathVariable String brid){
        return new ReturnParam(brandService.deleteById(brid));

    }

    @PutMapping("{brid}/{isValid}")
    @ResponseBody
    private ReturnParam updateIsValid(@PathVariable Integer brid,@PathVariable Integer isValid){


        return  new ReturnParam(brandService.updateIsValidById(brid,isValid));
    }

    @PostMapping
    @ResponseBody
    public ReturnParam save(@RequestBody Brand brand){

        return new ReturnParam(brandService.save(brand)) ;
    }
    @PostMapping("/checkform")
    public ReturnParam checkForm(@RequestBody Genres genres){
        String genrecode = genres.getGenrecode();
        return new ReturnParam(brandService.checkGenrecode(genrecode),"已经存在");
    }

}

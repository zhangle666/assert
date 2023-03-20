package com.virtue.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.virtue.model.ReturnParam;
import com.virtue.pojo.Warehous;
import com.virtue.service.WarehousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/warehous")

public class WarehousController {
    @Value("${photo.file.dir}")
    private String realPath;
    @Autowired
    private WarehousService service;

    private String rkPhone;

    @GetMapping
    public ReturnParam findAll(){
        return new ReturnParam(service.findAll());

    }
    @GetMapping("/downloadAllWarehous")
    public  void downloadAllWarehous(HttpServletResponse response){

        service.downloadAllWarehous(response);
    }
    @PostMapping("{currenPage}/{pageSize}")
    public ReturnParam toAssestGenre( @PathVariable int currenPage, @PathVariable int pageSize,@RequestBody Warehous warehous){

        IPage<Warehous> page = service.getPage(currenPage, pageSize,warehous);
        if (currenPage>page.getPages()){
            page = service.getPage((int) page.getPages(), pageSize,warehous);
        }
        return new ReturnParam(true,page) ;
    }
    @GetMapping("{waid}")
    @ResponseBody
    public ReturnParam getById(@PathVariable Integer waid){
        Warehous warehous = service.getById(waid);
        if (warehous!=null){
            return new ReturnParam(true,warehous);
        }
        return new ReturnParam(false);

    }
    @PutMapping
    @ResponseBody
    public ReturnParam Update(@RequestBody Warehous warehous){
        System.out.println(warehous);
        return new ReturnParam(service.update(warehous));

    }
    @DeleteMapping("{waid}")
    @ResponseBody
    public ReturnParam delete(@PathVariable Integer waid){
        return new ReturnParam(service.deleteById(waid));

    }

    @PostMapping
    @ResponseBody
    public ReturnParam save(@RequestBody Warehous warehous){
        System.out.println("------------------"+rkPhone);
        warehous.setWaimg(rkPhone);
        return new ReturnParam(service.save(warehous)) ;

    }
    @PostMapping("/phone")
    @ResponseBody
    public ReturnParam filephone( MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        //1.处理头像的上传&修改文件名称
        //1.1时间戳作为文件名前缀
        String fileNamePrefix = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        //1.2截取文件名后缀
        String fileNameSuffix = originalFilename.substring(originalFilename.lastIndexOf('.'));
        //1.3拼接成新的文件名
        String newFileName = fileNamePrefix + fileNameSuffix;
        try {
            file.transferTo(new File(realPath,newFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        rkPhone=newFileName;
        return null;
    }
}

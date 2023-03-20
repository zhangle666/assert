package com.virtue.controller;

import com.alibaba.druid.sql.visitor.functions.If;
import com.virtue.model.ReturnParam;
import com.virtue.pojo.User;
import com.virtue.service.SystemService;
import org.apache.shiro.session.UnknownSessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class SystemController {
        @Autowired
        private SystemService service;
        @Value("${photo.file.dir}")
        private String realpath;
    @RequestMapping("registers")
    @ResponseBody
    @PostMapping
    public ReturnParam registers(@RequestBody User user ,HttpSession session ){
        return  new ReturnParam(service.register(user));

    }
    @RequestMapping("/Userlogin")
    @ResponseBody
    public ReturnParam Userlogin(String username, String password , String code,HttpSession session){
        return service.loginCheck(username,password,code,session);



    }

    /**
     * 退出登录
     * @return 重定向到登录界面
     */
    @RequestMapping("/logout")
    public String logout(){
            service.logout();
        return "logout-success";
}

    @GetMapping("/activation")
    public String activationAccount(String confirmCode){

        ReturnParam param = service.activationAccount(confirmCode);
        if (param.getSuccess()){
            return "registerSussets" ;
        }

       return null;
    }
    @GetMapping("userinfo")
    public String getUserInfoByJobid(String jobid, Model model){
        System.out.println(jobid+"111111111111111111111111111111111");

        User userinfo = service.selectByJobid(jobid);
        model.addAttribute("userinfo",userinfo);
        return "assets-userinfo";
    }
    @RequestMapping("/updateUserInfo")
    public ModelAndView updateUserInfo(User user, MultipartFile img,ModelAndView modelAndView) {

        boolean empty = !img.isEmpty();
        if (empty) {
            User UserRes = service.selectByJobid(user.getJobid());
            File file = new File(realpath, UserRes.getPhoto());
            if (file.exists()) {
                file.delete();
            }
            String originalFilename = img.getOriginalFilename();
            String fileNamePrefix = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
            //1.2截取文件名后缀
            String fileNameSuffix = originalFilename.substring(originalFilename.lastIndexOf('.'));
            //1.3拼接成新的文件名
            String newFileName = fileNamePrefix + fileNameSuffix;
            try {
                img.transferTo(new File(realpath, newFileName));

            } catch (IOException e) {
                e.printStackTrace();
            }
            user.setPhoto(newFileName);
             }
            service.updateByJobid(user);
            modelAndView.setViewName("userInfoUadate-success");
        return modelAndView;
    }

}

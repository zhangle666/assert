package com.virtue.controller;

import com.virtue.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class SystemViewController {

    @RequestMapping("/index")
    public ModelAndView  toIndex(HttpSession session , ModelAndView modelAndView) {
        try {
            Thread.sleep(2000);//毫秒数
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user = (User) session.getAttribute("user");
        modelAndView.setViewName("index");
        modelAndView.addObject("user",user);

        return modelAndView;
    }

        @RequestMapping("/login")
        public String tologin(){

        return "login";
        }

    @RequestMapping("/register")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/overview")
    public String toOverview() {
        return "overview";
    }

    @RequestMapping("/test")
    public String totest() {

        return "/test";

    }
        @RequestMapping("/role")
    public String torele(){

        return "role-index";
        }
    @RequestMapping("/assetsGenres")
    public String torge(){

        return "assest-Genre";
    }
    @RequestMapping("/activation-account")
    public String toac(){

        return "activation-account";
    }
    @RequestMapping("/registerSussets")
    public String toresu(){

        return "registerSussets";
    }
    @RequestMapping("/assetsBrand")
    public String toBrand(){

        return "assets-Brand";
    }
    @RequestMapping("/assetsAchieve")
    public String toAchieve(){

        return "assets-Achieve";
    }
    @RequestMapping("/assetsSupplier")
    public String toSupplier(){

        return "assets-Supplier";
    }

    @RequestMapping("/assetsStore")
    public String toStore(){

        return "assets-Store";
    }
    @RequestMapping("/assetsScrap")
    public String toScrap(){

        return "assets-Scrap";
    }
    @RequestMapping("/userManage")
    public String toUserManage(){

        return "userManage";
    }
    @RequestMapping("/departmentManage")
    public String toDepartmentManage(){

        return "assets-department";
    }
    @RequestMapping("/PersonnelManage")
    public String toPersonnelManage(){

        return "assets-personnel";
    }
    @RequestMapping("/assetsSubscribe")
    public String toAssetssubscribe(){

        return "assets-Subscribe";
    }
    @RequestMapping("/assetsBorrowed")
    public String toBorrowed(){

        return "assets-Borrowed";
    }
    @RequestMapping("/assetsWarehous")
    public String toAssetsWarehous(){

        return "assets-Warehous";
    }
    @RequestMapping("/assetsTransfer")
    public String toAssetsTransfer(){

        return "assets-Transfer";
    }
    @RequestMapping("/assetsMaintain")
    public String toassetsMaintain(){

        return "assets-Maintain";
    }
    @RequestMapping("/assetsRetirement")
    public String toAssetsRetirement(){

        return "assets-Retirement";
    }
    @RequestMapping("/assetsRetirementSP")
    public String toassetsRetirementSP(){

        return "assets-RetirementSP";
    }
    @RequestMapping("/logoutSuccess")
    public String toLogoutSuccess(){

        return "logout-success";
    }
    @RequestMapping("/assetsUserinfo")
    public String toAssetsUserinfo(){

        return "assets-userinfo";
    }
    @RequestMapping("/assetsUserMa")
    public String toAssetsUserMa(){

        return "assets-UserMa";
    }
    @RequestMapping("/assetsSubscribeSP")
    public String toassetsSubscribeSP(){

        return "assets-SubscribeSP";
    }
    @RequestMapping("/assetsMaintainWX")
    public String toAssetsMaintainWX(){

        return "assets-MaintainWX";
    }
    @RequestMapping("/assestAca")
    public String toAssestAca(){

        return "assest-Aca";
    }
}

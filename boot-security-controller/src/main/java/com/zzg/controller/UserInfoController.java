package com.zzg.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
	/**
     * 用户查询.
     * @return
     */
    @RequestMapping("/userList")
    @Secured({"admin","user"})  
    public String userInfo(){
        return "userInfo";
    }
 
    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @Secured({"admin","user"})  
    public String userInfoAdd(){
        return "userInfoAdd";
    }
 
    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @Secured({"admin"})  
    public String userDel(){
        return "userInfoDel";
    }
}

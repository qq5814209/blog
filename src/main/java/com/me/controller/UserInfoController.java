package com.me.controller;

import com.me.pojo.UserInfo;
import com.me.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 查询用户信息、修改用户信息用controller
 */
@Controller
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    /**
     * 登录
     * @param user
     * @param password
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "userLogin",method = RequestMethod.POST)
    public Object login(String user, String password, HttpSession session){
        UserInfo userInfo = userInfoService.login(user,password);
        System.out.println(userInfo);
        session.setAttribute("userInfo",userInfo);
        return userInfo;
    }

    /**
     * 判断是否登录
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "islogin",method = RequestMethod.GET)
    public Object islogin(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

        return userInfo;
    }

    /**
     * 退出
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public boolean logout(HttpSession session){
        session.invalidate();
        return true;
    }






}
















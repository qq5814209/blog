package com.me.controller;

import com.me.pojo.UserInfo;
import com.me.service.UserInfoService;
import com.me.util.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
     * 注册
     * @param user_name
     * @param email
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "userRegiester",method = RequestMethod.POST)
    public Object regiester(String user_name,String email,String password){
        System.out.println(user_name + " : " + email + " : " + password);
        return userInfoService.regiester(user_name,email,password);
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

    /**
     * 从session获取用户id
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getUser_id")
    public Object getUser_id(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        int user_id = userInfo.getUser_id();
        return user_id;
    }

    /**
     * 获取验证码图片
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/captcha", method = RequestMethod.GET)
    @ResponseBody
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CaptchaUtil.outputCaptcha(request, response);
    }

}
















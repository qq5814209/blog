package com.me.controller;

import com.me.pojo.UserInfo;
import com.me.service.UserInfoService;
import com.me.util.BaseResult;
import com.me.util.CaptchaUtil;
import com.me.util.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
        UserInfo userInfo = userInfoService.login(user, Md5.getMD5(password));
        if(userInfo == null){
            return BaseResult.fail("账号或密码错误，请重新登录");
        }
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
        return userInfoService.regiester(user_name,email,Md5.getMD5(password));
    }

    /**
     * 判断新注册账号是否存在
     * @param user_name
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "user_nameIsExist",method = RequestMethod.GET)
    public Object user_nameIsExist(String user_name){
        if(user_name != null && user_name != ""){
            UserInfo userInfo = userInfoService.user_nameIsExist(user_name);
            if(userInfo != null){
                return BaseResult.fail("该账号已被注册");
            }
            return BaseResult.fail("该账号可以被使用");
        }
        return null;
    }

    /**
     * 更改用户激活状态
     * @param user_id
     * @return
     */
    @RequestMapping(value = "activate",method = RequestMethod.GET)
    public Object activate(String user_id){
        userInfoService.updateStatus(user_id);
        return "login";
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


    /**
     * 用户名检测
     * @param user_name
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cheUsername", method = RequestMethod.POST)
    public boolean cheUsername(String user_name){
       return userInfoService.cheUsername(user_name);
    }

}
















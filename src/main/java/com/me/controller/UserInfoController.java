package com.me.controller;

import com.me.pojo.UserInfo;
import com.me.service.UserInfoService;
import com.me.util.BaseResult;
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
     *
     * @param user
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "userLogin", method = RequestMethod.POST)
    public Object login(String user, String password, String captcha, HttpSession session) {
        String randomString = (String) session.getAttribute("randomString");
        if (randomString.equalsIgnoreCase(captcha)){
            UserInfo userInfo = userInfoService.login(user, password);
            if (userInfo.getStatus() == 1) {
                session.setAttribute("userInfo", userInfo);
                return userInfo;
            } else {
                BaseResult result = BaseResult.fail("你的账号未激活，请激活后再登录");
                return result;
            }
        }
        return BaseResult.fail("验证码错误");
    }

    /**
     * 判断是否登录
     *
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "islogin", method = RequestMethod.GET)
    public Object islogin(HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        return userInfo;
    }

    /**
     * 注册
     *
     * @param user_name
     * @param email
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "userRegiester", method = RequestMethod.POST)
    public Object regiester(String user_name, String email, String password,HttpSession session,String captcha) {
        if (captcha.equalsIgnoreCase((String) session.getAttribute("randomString"))){

            return userInfoService.regiester(user_name, email, password);
        }
        return 0;
    }

    /**
     * 新用户注册邮箱激活
     *
     * @param user_id
     * @return
     */
    @RequestMapping(value = "activate", method = RequestMethod.GET)
    public Object activate(String user_id) {
        System.out.println(user_id);
        userInfoService.updateStatus(user_id);
        return "index";
    }

    /**
     * 退出
     *
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public boolean logout(HttpSession session) {
        session.invalidate();
        return true;
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
















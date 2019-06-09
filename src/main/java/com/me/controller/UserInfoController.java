package com.me.controller;

import com.me.pojo.UserInfo;
import com.me.service.UserInfoService;
import com.me.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    public Object login(String user, String password,HttpSession session){
        System.out.println(user + " : "+password);
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
     * 根据用户id查询用户信息，用于展示 personal_center.html 页面
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectUserInfo",method = RequestMethod.POST)
    public Object selectUserInfo(){
//        因不知 id 是 session 中取，还是直接传 int id ，故先写死
        int userId = 1;
        UserInfoVo userInfoVo = userInfoService.selectUserInfo(userId);
        return userInfoVo;
    }

}

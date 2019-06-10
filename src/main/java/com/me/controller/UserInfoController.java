package com.me.controller;

import com.me.pojo.UserInfo;
import com.me.service.FavoritesService;
import com.me.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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


    /**
     * 根据用户id查询用户信息，用于展示 personal_center.html页面
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectUserInfo",method = RequestMethod.POST)
    public Object selectUserInfo(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        int userId = userInfo.getUser_id();
        return userInfoService.selectUserInfo(userId);
    }

    /**
     * 根据用户 id 查询用户收藏夹信息，用户展示 collect_center.html 页面
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectFavoritesByUserId", method = RequestMethod.POST)
    public Object selectFavoritesByUserId(HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        int userId = userInfo.getUser_id();
        return userInfoService.selectFavoritesByUserId(userId);
    }

    /**
     * 根据收藏夹id查询收藏夹中内容
     * @param favorites_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectFavoritesByFavoritesId", method = RequestMethod.POST)
    public Object selectFavoritesByFavoritesId(@RequestParam int favorites_id) {
        return userInfoService.selectFavoritesByFavoritesId(favorites_id);
    }

    @ResponseBody
    @RequestMapping(value = "/selectCareByUserId",method = RequestMethod.GET)
    public Object selectCareByUserId(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        int user_id = userInfo.getUser_id();
        return null;
    }

}
















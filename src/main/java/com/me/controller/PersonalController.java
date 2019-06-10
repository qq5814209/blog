package com.me.controller;

import com.me.pojo.UserInfo;
import com.me.service.PersonalService;
import com.me.dto.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class PersonalController {

    @Autowired
    PersonalService personalService;

    /**
     * 根据用户id查询用户信息，用于展示 personal_center.html 页面
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectUserInfo",method = RequestMethod.POST)
    public Object selectUserInfo(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        int userId = userInfo.getUser_id();
        UserInfoDto userInfoVo = personalService.selectUserInfo(userId);
        return userInfoVo;
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
        return personalService.selectFavoritesByUserId(userId);
    }

    /**
     * 根据收藏夹id查询收藏夹中内容
     * @param favorites_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectFavoritesByFavoritesId", method = RequestMethod.POST)
    public Object selectFavoritesByFavoritesId(@RequestParam int favorites_id) {
        return personalService.selectFavoritesByFavoritesId(favorites_id);
    }

    @ResponseBody
    @RequestMapping(value = "/selectCareByUserId",method = RequestMethod.GET)
    public Object selectCareByUserId(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        int user_id = userInfo.getUser_id();
        return null;
    }

}

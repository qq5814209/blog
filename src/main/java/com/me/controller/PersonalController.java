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
import java.util.List;

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
        UserInfoDto userInfoDto = personalService.selectCareByAttentionsAndFans(userId);
        userInfoDto.setUserInfo(userInfo);

        return userInfoDto;
    }

    /**
     * 根据用户 id 查询用户收藏夹信息，用于展示 collect_center.html 页面
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
    @RequestMapping(value = "/selectFavoritesByFavoritesId", method = RequestMethod.GET)
    public Object selectFavoritesByFavoritesId(@RequestParam int favorites_id) {
        System.out.println(favorites_id);
        return personalService.selectFavoritesByFavoritesId(favorites_id);
    }

    /**
     * 根据用户 id 查询用户的关注信息，用于展示 attention_center.html 页面
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectCareByUserId",method = RequestMethod.GET)
    public Object selectCareByUserId(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        int user_id = userInfo.getUser_id();
        return personalService.selectCareByUserId(user_id);
    }

    /**
     * 根据用户 id 查询该用户被那些用户关注，用于展示 fan_center.html 页面
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectCareByUserFromId",method = RequestMethod.GET)
    public Object selectCareByUserFromId(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        int user_id = userInfo.getUser_id();
        List<UserInfo> userInfoList = personalService.selectCareByUserFromId(user_id);
        return userInfoList;
    }

}

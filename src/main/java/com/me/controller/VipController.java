package com.me.controller;


import com.me.pojo.UserInfo;
import com.me.pojo.Vip;
import com.me.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class VipController {


    @Autowired
    VipService vipService;


    /**
     * 获取vip套餐
     * @param vip
     * @return vip套餐
     */
    @ResponseBody
    @RequestMapping(value ="/getVip",method = RequestMethod.POST)
    public Object test(@RequestBody(required = false) Vip vip){
        return vipService.getVip(vip);
    }

    /**
     * 查看自己是否为会员用户
     * @param session 直接发送请求过来
     * @return isVipVO实体，包括会员到期时间，开通的时间
     */
    @ResponseBody
    @RequestMapping(value ="isVip",method = RequestMethod.POST)
    public Object isVip(HttpSession session){
        return vipService.isVip(session);
    }



    /**
     * 查看自己是否为会员用户
     * @param userInfo 接受用户id
     * @return isVipVO实体，包括会员到期时间，开通的时间
     */
    @ResponseBody
    @RequestMapping(value ="isVipById",method = RequestMethod.POST)
    public Object isVipById(@RequestBody UserInfo userInfo ){
        return vipService.isVipById(userInfo);
    }




}

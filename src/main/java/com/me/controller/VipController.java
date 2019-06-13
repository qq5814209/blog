package com.me.controller;


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
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="/getVip",method = RequestMethod.POST)
    public Object test(@RequestBody(required = false) Vip vip){
        return vipService.getVip(vip);
    }

    /**
     * 查看是否为会员身份
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="isVip",method = RequestMethod.POST)
    public Object isVip(HttpSession session){
        return vipService.isVip(session);
    }

}

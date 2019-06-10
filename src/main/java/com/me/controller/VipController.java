package com.me.controller;


import com.me.pojo.Vip;
import com.me.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VipController {


    @Autowired
    VipService vipService;


    @ResponseBody
    @RequestMapping(value ="/getVip",method = RequestMethod.POST)
    public Object test(@RequestBody(required = false) Vip vip){
        return vipService.getVip(vip);
    }

}

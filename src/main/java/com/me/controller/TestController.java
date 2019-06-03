package com.me.controller;

import com.me.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    Service Service;

    @ResponseBody
    @RequestMapping("test")
    public String selectAll(){
        String s = Service.selectAll();
        return s;
    }


    @ResponseBody
    @RequestMapping("tests")
    public String selectAlls(){
        String s = Service.selectAll();
        return s;
    }


}

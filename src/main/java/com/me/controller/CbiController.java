package com.me.controller;

import com.me.pojo.Cbi;
import com.me.service.CbiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CbiController {

    @Autowired
    CbiService cbiService;


    /**
     * 获取C币套餐
     * @param cbi
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="getCbi",method = RequestMethod.POST)
    public List<Cbi> getCbi(@RequestBody(required = false) Cbi cbi){
        return cbiService.getCbi(cbi);
    }


    @ResponseBody
    @RequestMapping(value ="/test",method = RequestMethod.GET)
    public String test(){
        return "成功！";
    }


}

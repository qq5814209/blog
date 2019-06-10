package com.me.controller;

import com.me.dto.UserInfoDto;
import com.me.pojo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class BlogController {

    /**
     *  查询用户分类情况
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/asideContent",method = RequestMethod.POST)
    public Object asideContent(@RequestParam int userId){







        return null;
    }
}

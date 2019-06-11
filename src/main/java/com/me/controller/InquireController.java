package com.me.controller;
import com.me.dto.ShowDto;
import com.me.pojo.UserInfo;
import com.me.service.InquireService;
import com.me.vo.ShowVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class InquireController {

    @Autowired
    InquireService inquireService;

    /*
    * 根据博客类别名查询blog
    * */
    @ResponseBody
    @RequestMapping("getBlogsByTypeName")
    public Object getBlogsByTypeName(@RequestBody(required = false) ShowVo showVo){
        List<ShowDto> showDtos = inquireService.getBlogsByTypeName(showVo);
        return showDtos;
    }

    /*
    * 增加个人分类
    * */
    @ResponseBody
    @RequestMapping("addPersonalCategory")
    public Object addPersonalCategory(@RequestBody(required = false) ShowVo showVo, HttpSession httpSession){
        UserInfo userInfo = (UserInfo)httpSession.getAttribute("userInfo");
        int user_id = userInfo.getUser_id();
        showVo.setUser_id(user_id);
        boolean flag = inquireService.addPersonalCategory(showVo);
        return flag;
    }


    /*
     * 显示个人分类所有类别
     * */
    @ResponseBody
    @RequestMapping("AllPersonalCategory")
    public Object AllPersonalCategory(@RequestBody(required = false) ShowVo showVo, HttpSession httpSession){
        UserInfo userInfo = (UserInfo)httpSession.getAttribute("userInfo");
        int user_id = userInfo.getUser_id();
        showVo.setUser_id(user_id);
        List<ShowDto> showDtos = inquireService.AllPersonalCategory(showVo);
        return showDtos;
    }



}

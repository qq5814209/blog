package com.me.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    * 根据博客类别名查询blog或者查所有blog
    * */
    @ResponseBody
    @RequestMapping("getBlogsByTypeName")
    public Object getBlogsByTypeName(@RequestBody(required = false) ShowVo showVo){
        PageHelper.startPage(showVo.getCurrentPage(), showVo.getPageSize());
        List<ShowDto> showDtos = inquireService.getBlogsByTypeName(showVo);
        PageInfo<ShowDto> showDtoPageInfo = new PageInfo<ShowDto>(showDtos);
        return showDtoPageInfo;
    }

    /*
    * 根据用户user_id查该用户的所有blog
    * */
    @ResponseBody
    @RequestMapping("getBlogsByUserId")
    public Object getBlogsByUserId(@RequestBody(required = false)ShowVo showVo ,HttpSession session){
        UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
        int user_id = userInfo.getUser_id();
        showVo.setUser_id(user_id);
        PageHelper.startPage(showVo.getCurrentPage(), showVo.getPageSize());
        List<ShowDto> showDtos = inquireService.getBlogsByUserId(showVo);
        PageInfo<ShowDto> showDtoPageInfo = new PageInfo<ShowDto>(showDtos);

        return showDtoPageInfo;
    }

    /*
    * 增加个人分类
    * */
    @ResponseBody
    @RequestMapping("addPersonalCategory")
    public Object addPersonalCategory(@RequestBody(required = false) ShowVo showVo, HttpSession session){
        UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
        int user_id = userInfo.getUser_id();
        showVo.setUser_id(user_id);
        System.out.println("showVo:"+showVo);
        boolean flag = inquireService.addPersonalCategory(showVo);
        return flag;
    }


    /*
     * 显示个人分类所有类别
     * */
    @ResponseBody
    @RequestMapping("allPersonalCategory")
    public Object allPersonalCategory(@RequestBody(required = false) ShowVo showVo, HttpSession httpSession){

        PageHelper.startPage(showVo.getCurrentPage(), showVo.getPageSize());
        UserInfo userInfo = (UserInfo)httpSession.getAttribute("userInfo");
        int user_id = userInfo.getUser_id();
        showVo.setUser_id(user_id);
        List<ShowDto> showDtos = inquireService.allPersonalCategory(showVo);
        PageInfo<ShowDto> showDtoPageInfo = new PageInfo<ShowDto>(showDtos);

        return showDtoPageInfo;
    }


    /*
     * 删除个人分类类别
     * */
    @ResponseBody
    @RequestMapping("deletePersonalCategory")
    public Object deletePersonalCategory(@RequestBody(required = false) ShowVo showVo, HttpSession httpSession){
        UserInfo userInfo = (UserInfo)httpSession.getAttribute("userInfo");
        int user_id = userInfo.getUser_id();
        showVo.setUser_id(user_id);
        boolean flag = inquireService.deletePersonalCategory(showVo);
        return flag;
    }

    /*
     * 修改个人分类类别
     * */
    @ResponseBody
    @RequestMapping("updatePersonalCategory")
    public Object updatePersonalCategory(@RequestBody(required = false) ShowVo showVo, HttpSession httpSession){
        System.out.println("保存");
        System.out.println(showVo);
        UserInfo userInfo = (UserInfo)httpSession.getAttribute("userInfo");
        int user_id = userInfo.getUser_id();
        showVo.setUser_id(user_id);
        boolean flag = inquireService.updatePersonalCategory(showVo);
        System.out.println(flag+"flag來了");
        return flag;
    }

    /*
     * 搜索框搜索
     * */
    @ResponseBody
    @RequestMapping("searchBlogs")
    public Object searchBlogs(@RequestBody(required = false) ShowVo showVo){

        PageHelper.startPage(showVo.getCurrentPage(), showVo.getPageSize());
        List<ShowDto> showDtos = inquireService.searchBlogs(showVo);
        PageInfo<ShowDto> showDtoPageInfo = new PageInfo<ShowDto>(showDtos);
        return showDtoPageInfo;
    }

//    @ResponseBody
//    @RequestMapping("searchBlogs")
//    public Object searchBlogs(@RequestBody(required = false) String str){
//        List<ShowDto> showDtos = inquireService.searchBlogs(str);
//        return showDtos;
//    }

}

package com.me.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.me.dto.Blog_TypeDto;
import com.me.dto.Person_TypeDto;
import com.me.dto.ShowDto;
import com.me.pojo.UserInfo;
import com.me.service.InquireService;
import com.me.util.BaseResult;
import com.me.vo.ShowVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    public Object deletePersonalCategory(@RequestBody(required = false) ShowVo showVo){
        boolean flag = inquireService.deletePersonalCategory(showVo);
        return flag;
    }

    /*
     * 修改个人分类类别
     * */
    @ResponseBody
    @RequestMapping("updatePersonalCategory")
    public Object updatePersonalCategory(@RequestBody(required = false) ShowVo showVo, HttpSession httpSession){

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


    @ResponseBody
    @RequestMapping("deleteBlogbyBlog_id")
    public Object deleteBlogbyBlog_id(@RequestBody(required = false) ShowVo showVo){
        boolean flag = inquireService.deleteBlogbyBlog_id(showVo);
        return flag;
    }


    /*
    * 展示我文章的评论
    * */
    @ResponseBody
    @RequestMapping("showMyComment")
    public Object showMyComment(@RequestBody(required = false) ShowVo showVo,HttpSession session){
        UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
        int user_id = userInfo.getUser_id();
        showVo.setUser_id(user_id);
        PageHelper.startPage(showVo.getCurrentPage(), showVo.getPageSize());
        List<ShowDto> showDtos = inquireService.showMyComment(showVo);
        PageInfo<ShowDto> showDtoPageInfo = new PageInfo<ShowDto>(showDtos);

        return showDtoPageInfo;
    }


    /*
    * 删除文章的评论
    * */
    @ResponseBody
    @RequestMapping("delComment")
    public Object delComment(@RequestBody(required = false) ShowVo showVo){
        boolean flag = inquireService.delComment(showVo);
        return flag;
    }

    /**
     * 个人分类类型和查询博客类型
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "selectPersonTypeAndBlogType",method = RequestMethod.GET)
    public Object selectBlogType(){
        //查询个人分类类型
        List<Person_TypeDto> person_typeDtos = inquireService.selectPersonType();
        //查询博客类型
        List<Blog_TypeDto> blog_typeDtos = inquireService.selectBlogType();
        ArrayList<Object> type = new ArrayList<Object>();
        type.add(person_typeDtos);
        type.add(blog_typeDtos);
        return type;
    }

    /**
     * 写博客
     * @param httpSession
     * @param txtTitle
     * @param content
     * @param blogType
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "writeBlog",method = RequestMethod.POST)
    public Object writeBlog(HttpSession httpSession,String txtTitle,String content,String typeSpan,String blogType){
        System.out.println(txtTitle);
        System.out.println(content);
        System.out.println(typeSpan);
        System.out.println(blogType);
        UserInfo userInfo = (UserInfo)httpSession.getAttribute("userInfo");
        int user_id = userInfo.getUser_id();
        int i = inquireService.writeBlog(user_id,txtTitle,content,typeSpan,blogType);
        if(i == 0){
            return BaseResult.fail("服务器正在维护，写博客功能延迟开放");
        }
        return BaseResult.success("博客发表成功");
    }


}

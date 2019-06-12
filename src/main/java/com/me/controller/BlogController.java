package com.me.controller;

import com.me.dto.BlogDto;
import com.me.dto.BlogNumDto;
import com.me.dto.ClassificationDto;
import com.me.dto.CommentDto;
import com.me.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;
    /**
     *  查询用户分类情况
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/asideContent")
    public Object asideContent(@RequestParam int userId){
        List<ClassificationDto> aClass = blogService.findClass(userId);
        if (aClass!=null){
            return aClass;
        }
       return null;
    }

    /**
     *  获取用户每个月博客发布数量
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/archiveList")
    public Object archiveList(@RequestParam int userId){
        List<BlogNumDto> blogNum = blogService.findBlogNum(userId);
        return blogNum;
    }

    /**
     *  通过用户id查询用户所有的博客
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/showBlog")
    public Object showBlog(@RequestParam int userId){

        List<BlogDto> blogList = blogService.showBlog(userId);
        return blogList;
    }

    /**
     *  通过用户id与时间查询某月所有新增博客
     * @param blogNumDto
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/showBlogByTime")
    public Object showBlogByTime(@RequestBody BlogNumDto blogNumDto){

        List<BlogDto> blogList = blogService.showBlogByTime(blogNumDto);
        return blogList;
    }
    /**
     *  通过用户id与用户个人分类id查询所有新增博客
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/showBlogByClassId")
    public Object showBlogByClassId(@RequestBody ClassificationDto classificationDto){

        List<BlogDto> blogList = blogService.showBlogByClassId(classificationDto);
        return blogList;
    }

    /**
     *  通过用户id查询最新的5条评论
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findComment")
    public Object findComment(@RequestParam int userId){
        List<CommentDto> commentDtoList = blogService.findComment(userId);
        return commentDtoList;
    }

    /**
     *  通过博客id以及用户id查询对应的博客文章信息
     * @param blogDto
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/showArticle")
    public Object showArticle(@RequestBody BlogDto blogDto){
        List<BlogDto> blogDtoList = blogService.showArticle(blogDto);
        return blogDtoList;
    }

    /**
     *  通过用户id查询最近更新的博客
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/showBlogByNewTime")
    public Object showBlogByNewTime(@RequestParam int userId){
        List<BlogDto> blogDtoList = blogService.showBlogByNewTime(userId);
        return blogDtoList;
    }


}

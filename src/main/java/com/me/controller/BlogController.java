package com.me.controller;

import com.me.dto.*;
import com.me.pojo.Comment;
import com.me.pojo.UserInfo;
import com.me.service.BlogService;
import com.me.vo.ReportVo;
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

    /**
     *  通过用户id查询访问量排名靠前的博客
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/showBlogByCommentNum")
    public Object showBlogByCommentNum(@RequestParam int userId){
        List<BlogDto> blogDtoList = blogService.showBlogByCommentNum(userId);
        return blogDtoList;
    }

    /**
     *  通过登录者的id查询用户信息
     * @param loginUserId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/showCommentBox")
    public Object showCommentBox(@RequestParam int loginUserId){
        UserInfo userInfo = blogService.showCommentBox(loginUserId);
        return userInfo;
    }

    /**
     *  获取评论对象，用于新增最新评论
     * @param comment
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addComment")
    public Object addComment(@RequestBody Comment comment){
        int num = blogService.addComment(comment);
        return num;
    }

    /**
     *  通过用户id信息查询用户所有统计数据信息
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findUserDto")
    public Object findUserDto(@RequestParam int userId){
        UserDto userDto = blogService.findUserDto(userId);
        return userDto;
    }

    /**
     * 添加举报信息
     * @param reportVo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insertReportMessage", method = RequestMethod.POST)
    public Object insertReportMessage(ReportVo reportVo){
        return blogService.insertReportMessage(reportVo);
    }

}

package com.me.service.impl;

import com.me.dto.*;
import com.me.mapper.BlogMapper;
import com.me.pojo.Comment;
import com.me.pojo.UserInfo;
import com.me.service.BlogService;
import com.me.vo.ReportVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;
    public List<ClassificationDto> findClass(int userId) {
        List<ClassificationDto> mapperClass = blogMapper.findClass(userId);
        return mapperClass;
    }

    public List<BlogNumDto> findBlogNum(int userId) {
        List<BlogNumDto> blogNumDtoList =blogMapper.findBlogNum(userId);
        return blogNumDtoList;
    }

    public List<BlogDto> showBlog(int userId) {
        List<BlogDto> blogDtoList = blogMapper.showBlog(userId);
        return blogDtoList;
    }

    public List<BlogDto> showBlogByTime(BlogNumDto blogNumDto) {
        List<BlogDto> blogDtoList = blogMapper.showBlogByTime(blogNumDto);
        return blogDtoList;
    }

    public List<BlogDto> showBlogByClassId(ClassificationDto classificationDto) {
        List<BlogDto> blogDtoList = blogMapper.showBlogByClassId(classificationDto);
        return blogDtoList;
    }

    public List<CommentDto> findComment(int userId) {
        List<CommentDto> commentDtoList =  blogMapper.findComment(userId);
        return commentDtoList;
    }

    public List<BlogDto> showArticle(BlogDto blogDto) {
        List<BlogDto> blogDtoList = blogMapper.showArticle(blogDto);
        return blogDtoList;
    }

    public List<BlogDto> showBlogByNewTime(int userId) {
        List<BlogDto> blogDtoList = blogMapper.showBlogByNewTime(userId);
        return blogDtoList;
    }

    @Override
    public List<BlogDto> showBlogByCommentNum(int userId) {
        List<BlogDto> blogDtoList = blogMapper.showBlogByCommentNum(userId);
        return blogDtoList;
    }

    @Override
    public UserInfo showCommentBox(int loginUserId) {
        UserInfo userInfo = blogMapper.showCommentBox(loginUserId);
        return userInfo;
    }

    @Override
    public int addComment(Comment comment) {
        int num = blogMapper.addComment(comment);
        return num;
    }

    @Override
    public UserDto findUserDto(int userId) {
        UserDto userDto = blogMapper.findUserDto(userId);
        return userDto;
    }

    /**
     * 添加举报信息
     * @param reportVo
     * @return
     */
    @Override
    public boolean insertReportMessage(ReportVo reportVo) {

        return blogMapper.insertReportMessage(reportVo) > 0;
    }

}

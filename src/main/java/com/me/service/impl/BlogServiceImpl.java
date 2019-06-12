package com.me.service.impl;

import com.me.dto.BlogDto;
import com.me.dto.BlogNumDto;
import com.me.dto.ClassificationDto;
import com.me.dto.CommentDto;
import com.me.mapper.BlogMapper;
import com.me.service.BlogService;
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

}

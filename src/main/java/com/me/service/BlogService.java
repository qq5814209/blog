package com.me.service;

import com.me.dto.BlogDto;
import com.me.dto.BlogNumDto;
import com.me.dto.ClassificationDto;

import java.util.List;

public interface BlogService {
    /**
     *  查询用户博客的所有分类
     * @return
     */
    List<ClassificationDto> findClass(int userId);

    /**
     *  通过用户id查询用户个人分类的博客数量
     * @param userId
     * @return
     */
    List<BlogNumDto> findBlogNum(int userId);

    /**
     *  通过用户id查询用户所有的博客
     * @param userId
     * @return
     */
    List<BlogDto> showBlog(int userId);

    /**
     *  通过用户id与时间查询某月所有新增博客
     * @param blogNumDto
     * @return
     */
    List<BlogDto> showBlogByTime(BlogNumDto blogNumDto);

    /**
     *  通过用户id与用户个人分类id查询所有新增博客
     * @param classificationDto
     * @return
     */
    List<BlogDto> showBlogByClassId(ClassificationDto classificationDto);
}

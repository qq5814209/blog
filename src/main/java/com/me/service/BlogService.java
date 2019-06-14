package com.me.service;

import com.me.dto.*;
import com.me.pojo.Comment;
import com.me.pojo.UserInfo;
import com.me.vo.ShowVo;

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

    /**
     *  通过用户id查询最新的5条评论
     * @param userId
     * @return
     */
    List<CommentDto> findComment(int userId);

    /**
     *  通过博客id以及用户id查询对应的博客文章信息
     * @param blogDto
     * @return
     */
    List<BlogDto> showArticle(BlogDto blogDto);

    /**
     *  通过用户id查询最近更新的博客
     * @param userId
     * @return
     */
    List<BlogDto> showBlogByNewTime(int userId);

    /**
     *  通过用户id查询访问量排名靠前的博客
     * @param userId
     * @return
     */
    List<BlogDto> showBlogByCommentNum(int userId);

    /**
     *  通过登录者的id查询用户信息
     * @param loginUserId
     * @return
     */
    UserInfo showCommentBox(int loginUserId);

    /**
     * 获取评论对象，用于新增最新评论
     * @param comment
     * @return
     */
    int addComment(Comment comment);

    /**
     *  通过用户id信息查询用户所有统计数据信息
     * @param userId
     * @return
     */
    UserDto findUserDto(int userId);

    public int getPraise(ShowVo showVo);

    public ShowDto selectPraise1(ShowVo showVo);

    public int updatePraise(ShowVo showVo);

    public ShowDto selectPraise2(ShowVo showVo);

    public ShowDto getBrowse(ShowVo showVo);

    public int addBrowse(ShowVo showVo);

    public ShowDto selectBrowse(ShowVo showVo);
}

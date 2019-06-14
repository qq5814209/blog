package com.me.mapper;

import com.me.dto.*;
import com.me.pojo.Comment;
import com.me.pojo.UserInfo;

import com.me.vo.ReportVo;

import com.me.vo.ShowVo;


import java.util.List;

public interface BlogMapper {


    List<ClassificationDto> findClass(int userId);

    List<BlogNumDto> findBlogNum(int userId);

    List<BlogDto> showBlog(int userId);

    List<BlogDto> showBlogByTime(BlogNumDto blogNumDto);

    List<BlogDto> showBlogByClassId(ClassificationDto classificationDto);

    List<CommentDto> findComment(int userId);

    List<BlogDto> showArticle(BlogDto blogDto);

    List<BlogDto> showBlogByNewTime(int userId);

    List<BlogDto> showBlogByCommentNum(int userId);

    UserInfo showCommentBox(int loginUserId);

    int addComment(Comment comment);

    UserDto findUserDto(int userId);

    List<Comment> showCommentByBlogId(int blogId);
    /**
     * 添加举报信息
     * @param reportVo
     * @return
     */
    int insertReportMessage(ReportVo reportVo);

    public int getPraise(ShowVo showVo);

    public ShowDto selectPraise1(ShowVo showVo);

    public int xiuGaiPraise(ShowVo showVo);

    public ShowDto selectPraise2(ShowVo showVo);

//    public ShowDto getBrowse(ShowVo showVo);

    public int addBrowse(ShowVo showVo);

    public ShowDto selectBrowse(ShowVo showVo);


}

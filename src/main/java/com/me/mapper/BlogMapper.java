package com.me.mapper;

import com.me.dto.*;
import com.me.pojo.Comment;
import com.me.pojo.UserInfo;

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
}

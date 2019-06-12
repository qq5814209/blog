package com.me.dto;

import java.io.Serializable;

public class CommentDto implements Serializable {

    private int userId; //博客发布人的id
    private int blogId; //博客的id
    private String title; //博客的标题
    private String name; //评论人的用户名
    private String comment; //评论

    public CommentDto() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

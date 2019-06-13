package com.me.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用于渲染评论消息页的数据
 */
public class InformCommentDto {

    private int comment_id;
    private int user_id;
    private int blog_id;
    private String comment_content;
    private String comment_time;
    private String name;
    private int informComment_id;
    private int status;
    private int comments;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(Date comment_time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(comment_time);
        this.comment_time = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInformComment_id() {
        return informComment_id;
    }

    public void setInformComment_id(int informComment_id) {
        this.informComment_id = informComment_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "InformCommentDto{" +
                "comment_id=" + comment_id +
                ", user_id=" + user_id +
                ", blog_id=" + blog_id +
                ", comment_content='" + comment_content + '\'' +
                ", comment_time=" + comment_time +
                ", name='" + name + '\'' +
                ", informComment_id=" + informComment_id +
                ", status=" + status +
                ", comments=" + comments +
                '}';
    }
}

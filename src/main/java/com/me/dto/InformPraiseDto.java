package com.me.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用于渲染点赞消息页面
 */
public class InformPraiseDto {
    private int user_id;
    private String name;
    private String praise_time;
    private int blog_id;
    private String blog_title;
    private int informpraise_id;
    private int status;
    private int unread;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPraise_time() {
        return praise_time;
    }

    public void setPraise_time(Date praise_time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.praise_time = simpleDateFormat.format(praise_time);
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public String getBlog_title() {
        return blog_title;
    }

    public void setBlog_title(String blog_title) {
        this.blog_title = blog_title;
    }

    public int getInformpraise_id() {
        return informpraise_id;
    }

    public void setInformpraise_id(int informpraise_id) {
        this.informpraise_id = informpraise_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUnread() {
        return unread;
    }

    public void setUnread(int unread) {
        this.unread = unread;
    }

    @Override
    public String toString() {
        return "InformPraiseDto{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", praise_time='" + praise_time + '\'' +
                ", blog_id=" + blog_id +
                ", blog_title='" + blog_title + '\'' +
                ", informpraise_id=" + informpraise_id +
                ", status=" + status +
                ", unread=" + unread +
                '}';
    }
}

package com.me.dto;

public class ShowDto {
    private String name;//用户昵称
    private String type_name;//blog分类
    private String blog_title;//blog标题
    private String blog_content;//blog内容
    private String create_time;//blog创建时间
    private int cnumber;//评论数
    private int bnumber;//浏览数
    private int user_id;//用户id
    private int wznumber;//文章数量


    public int getWznumber() {
        return wznumber;
    }

    public void setWznumber(int wznumber) {
        this.wznumber = wznumber;
    }

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

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getBlog_title() {
        return blog_title;
    }

    public void setBlog_title(String blog_title) {
        this.blog_title = blog_title;
    }

    public String getBlog_content() {
        return blog_content;
    }

    public void setBlog_content(String blog_content) {
        this.blog_content = blog_content;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getCnumber() {
        return cnumber;
    }

    public void setCnumber(int cnumber) {
        this.cnumber = cnumber;
    }

    public int getBnumber() {
        return bnumber;
    }

    public void setBnumber(int bnumber) {
        this.bnumber = bnumber;
    }

    @Override
    public String toString() {
        return "ShowDto{" +
                "name='" + name + '\'' +
                ", type_name='" + type_name + '\'' +
                ", blog_title='" + blog_title + '\'' +
                ", blog_content='" + blog_content + '\'' +
                ", create_time='" + create_time + '\'' +
                ", cnumber=" + cnumber +
                ", bnumber=" + bnumber +
                ", user_id=" + user_id +
                ", wznumber=" + wznumber +
                '}';
    }
}

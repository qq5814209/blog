package com.me.dto;

public class ShowDto {
    private int blog_id;//博客id
    private String name;//用户昵称
    private String type_name;//blog分类
    private String blog_title;//blog标题
    private String blog_content;//blog内容
    private String create_time;//blog创建时间
    private int cnumber;//评论数
    private int bnumber;//浏览数
    private int user_id;//用户id
    private int wznumber;//文章数量
    private int bt_id;//博客分类id
    private int status;
    private String blog_url;//博客链接
    private int pt_id;//个人分类id
    private int currentPage;//当前页
    private int pageSize;//当前页数据条数
    private int uid;
    private String comment_content;//评论内容
    private String comment_time;//评论时间
    private int comment_id;//评论id



    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
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

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getBt_id() {
        return bt_id;
    }

    public void setBt_id(int bt_id) {
        this.bt_id = bt_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBlog_url() {
        return blog_url;
    }

    public void setBlog_url(String blog_url) {
        this.blog_url = blog_url;
    }

    public int getPt_id() {
        return pt_id;
    }

    public void setPt_id(int pt_id) {
        this.pt_id = pt_id;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

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
                "blog_id=" + blog_id +
                ", name='" + name + '\'' +
                ", type_name='" + type_name + '\'' +
                ", blog_title='" + blog_title + '\'' +
                ", blog_content='" + blog_content + '\'' +
                ", create_time='" + create_time + '\'' +
                ", cnumber=" + cnumber +
                ", bnumber=" + bnumber +
                ", user_id=" + user_id +
                ", wznumber=" + wznumber +
                ", bt_id=" + bt_id +
                ", status=" + status +
                ", blog_url='" + blog_url + '\'' +
                ", pt_id=" + pt_id +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", uid=" + uid +
                ", comment_content='" + comment_content + '\'' +
                ", comment_time='" + comment_time + '\'' +
                ", comment_id=" + comment_id +
                '}';
    }
}

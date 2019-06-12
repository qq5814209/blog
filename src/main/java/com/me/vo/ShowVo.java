package com.me.vo;

public class ShowVo {
    private String name;//用户昵称
    private String type_name;//blog分类或个人分类
    private String blog_title;//blog标题
    private String blog_content;//blog内容
    private String create_time;//blog创建时间
    private int cnumber;//评论数
    private int bnumber;//浏览数
    private String blog_id;//博客id
    private String bt_id;//博客类别id
    private int pt_id;//个人分类
    private int user_id;//用户id
    private String str;//搜索框的值

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
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

    public String getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(String blog_id) {
        this.blog_id = blog_id;
    }

    public String getBt_id() {
        return bt_id;
    }

    public void setBt_id(String bt_id) {
        this.bt_id = bt_id;
    }

    public int getPt_id() {
        return pt_id;
    }

    public void setPt_id(int pt_id) {
        this.pt_id = pt_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "ShowVo{" +
                "name='" + name + '\'' +
                ", type_name='" + type_name + '\'' +
                ", blog_title='" + blog_title + '\'' +
                ", blog_content='" + blog_content + '\'' +
                ", create_time='" + create_time + '\'' +
                ", cnumber=" + cnumber +
                ", bnumber=" + bnumber +
                ", blog_id='" + blog_id + '\'' +
                ", bt_id='" + bt_id + '\'' +
                ", pt_id=" + pt_id +
                ", user_id=" + user_id +
                ", str='" + str + '\'' +
                '}';
    }
}

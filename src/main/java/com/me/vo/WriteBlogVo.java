package com.me.vo;

public class WriteBlogVo {
    int user_id;//用户id
    int blog_id;//博客id
    String txtTitle;//博客标题
    String content;//博客内容
    String typeSpan;//个人分类
    String blogType;//博客类型

    public String getTypeSpan() {
        return typeSpan;
    }

    public void setTypeSpan(String typeSpan) {
        this.typeSpan = typeSpan;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTxtTitle() {
        return txtTitle;
    }

    public void setTxtTitle(String txtTitle) {
        this.txtTitle = txtTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBlogType() {
        return blogType;
    }

    public void setBlogType(String blogType) {
        this.blogType = blogType;
    }
}

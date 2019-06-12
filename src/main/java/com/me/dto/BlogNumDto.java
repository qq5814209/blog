package com.me.dto;

import java.io.Serializable;

public class BlogNumDto implements Serializable {

    private int userId;          //用户名
    private String years;          //创建的时间
    private String months;
    private int blogNum;        //当月博客数量

    public BlogNumDto() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBlogNum() {
        return blogNum;
    }

    public void setBlogNum(int blogNum) {
        this.blogNum = blogNum;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }
}

package com.me.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

    private String name; //博客的用户名
    private String url;// 用户的头像
    private int blogNum;//博客数量
    private int careNum;//粉丝数量
    private int loveNum;//喜欢的数量
    private int commentNum;//评论数量
    private int levelValue;//积分
    private int seeNum;//访问量
    private int levelNum;//等级
    private int rankNum;//排名

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getBlogNum() {
        return blogNum;
    }

    public void setBlogNum(int blogNum) {
        this.blogNum = blogNum;
    }

    public int getCareNum() {
        return careNum;
    }

    public void setCareNum(int careNum) {
        this.careNum = careNum;
    }

    public int getLoveNum() {
        return loveNum;
    }

    public void setLoveNum(int loveNum) {
        this.loveNum = loveNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getLevelValue() {
        return levelValue;
    }

    public void setLevelValue(int levelValue) {
        this.levelValue = levelValue;
    }

    public int getSeeNum() {
        return seeNum;
    }

    public void setSeeNum(int seeNum) {
        this.seeNum = seeNum;
    }

    public int getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(int levelValue) {
        if (levelValue<100){
            levelNum = 1;
        }else if (levelValue<500){
            levelNum = 2;
        }else if (levelValue<1000){
            levelNum = 3;
        }else if (levelValue<2000){
            levelNum = 4;
        }else if (levelValue<5000){
            levelNum = 5;
        }else if (levelValue<10000){
            levelNum = 6;
        }else if (levelValue<50000){
            levelNum = 7;
        }else if (levelValue<100000){
            levelNum = 8;
        }else if (levelValue>=1000000){
            levelNum = 9;
        }
    }

    public int getRankNum() {
        return rankNum;
    }

    public void setRankNum(int rankNum) {
        this.rankNum = rankNum;
    }
}

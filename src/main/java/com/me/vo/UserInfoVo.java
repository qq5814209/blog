package com.me.vo;

import com.me.pojo.UserInfo;

/**
 * 用于展示 personal_center.html 页面
 */
public class UserInfoVo {
//    用户信息
    private UserInfo userInfo;
//    用户粉丝数
    private int fans;
//    用户关注数
    private int attentions;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public int getAttentions() {
        return attentions;
    }

    public void setAttentions(int attentions) {
        this.attentions = attentions;
    }

    @Override
    public String toString() {
        return "UserInfoVo{" +
                "userInfo=" + userInfo +
                ", fans=" + fans +
                ", attentions=" + attentions +
                '}';
    }
}

package com.me.vo;

public class IsVipVo {
    //用户id
    private int user_id;
    //用户名
    private String user_name;
    //上次开通的时间
    private String statr_time;
    //会员到期的时间
    private String end_time;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getStatr_time() {
        return statr_time;
    }

    public void setStatr_time(String statr_time) {
        this.statr_time = statr_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "IsVipVo{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", statr_time='" + statr_time + '\'' +
                ", end_time='" + end_time + '\'' +
                '}';
    }
}

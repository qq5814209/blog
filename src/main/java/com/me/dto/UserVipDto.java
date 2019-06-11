package com.me.dto;

public class UserVipDto {
    private int user_id;
    private String vip_id;
    private String statr_time;
    private String end_time;
    private int status;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getVip_id() {
        return vip_id;
    }

    public void setVip_id(String vip_id) {
        this.vip_id = vip_id;
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
        this.end_time = "-"+end_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserVipDto{" +
                "user_id=" + user_id +
                ", vip_id=" + vip_id +
                ", statr_time='" + statr_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", status=" + status +
                '}';
    }
}

package com.me.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用于渲染系统消息页面
 */
public class InformSystemDto {
    private int inform_id;
    private int user_id;
    private String inform_title;
    private String inform_desc;
    private int status;
    private int unreads;
    private String create_time;

    public int getInform_id() {
        return inform_id;
    }

    public void setInform_id(int inform_id) {
        this.inform_id = inform_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getInform_title() {
        return inform_title;
    }

    public void setInform_title(String inform_title) {
        this.inform_title = inform_title;
    }

    public String getInform_desc() {
        return inform_desc;
    }

    public void setInform_desc(String inform_desc) {
        this.inform_desc = inform_desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUnreads() {
        return unreads;
    }

    public void setUnreads(int unreads) {
        this.unreads = unreads;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.create_time = simpleDateFormat.format(create_time);
    }

    @Override
    public String toString() {
        return "InformSystemDto{" +
                "inform_id=" + inform_id +
                ", user_id=" + user_id +
                ", inform_title='" + inform_title + '\'' +
                ", inform_desc='" + inform_desc + '\'' +
                ", status=" + status +
                ", unreads=" + unreads +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}

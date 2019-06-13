package com.me.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用于渲染关注消息页的数据
 */
public class InformCareDto {
    private int informcare_id;
    private int user_id;
    private String name;
    private String create_time;

    public int getInformcare_id() {
        return informcare_id;
    }

    public void setInformcare_id(int informcare_id) {
        this.informcare_id = informcare_id;
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

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "InformCareDto{" +
                "informcare_id=" + informcare_id +
                ", user_id=" + user_id +
                ", name='" + name + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}

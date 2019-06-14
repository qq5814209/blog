package com.me.dto;

public class UserCbiDto {
    private int user_id;
    private int cbi_number;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCbi_number() {
        return cbi_number;
    }

    public void setCbi_number(int cbi_number) {
        this.cbi_number = cbi_number;
    }

    @Override
    public String toString() {
        return "UserCbiDto{" +
                "user_id=" + user_id +
                ", cbi_number=" + cbi_number +
                '}';
    }
}

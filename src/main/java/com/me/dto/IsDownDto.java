package com.me.dto;

public class IsDownDto {
    private int file_cbi;
    private int cbis;
    private String file_name;
    private int file_id;
    private int du_id;
    private int user_id;
    private String down_time;

    public int getFile_cbi() {
        return file_cbi;
    }

    public void setFile_cbi(int file_cbi) {
        this.file_cbi = file_cbi;
    }

    public int getCbis() {
        return cbis;
    }

    public void setCbis(int cbis) {
        this.cbis = cbis;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public int getFile_id() {
        return file_id;
    }

    public void setFile_id(int file_id) {
        this.file_id = file_id;
    }

    public int getDu_id() {
        return du_id;
    }

    public void setDu_id(int du_id) {
        this.du_id = du_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDown_time() {
        return down_time;
    }

    public void setDown_time(String down_time) {
        this.down_time = down_time;
    }
}

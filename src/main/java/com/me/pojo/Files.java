package com.me.pojo;

public class Files {

    /*文件Id*/
    private int file_id;
    /*文件拥有者的Id，也做下载着的Id*/
    private int user_id;
    /*文件的名称*/
    private String file_name;
    /*文件的状态*/
    private int status;
    /*文件下载所需的C币*/
    private int file_cbi;
    /*文件上传的时间*/
    private String file_time;

    public String getFile_time() {
        return file_time;
    }

    public void setFile_time(String file_time) {
        this.file_time = file_time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getFile_cbi() {
        return file_cbi;
    }

    public void setFile_cbi(int file_cbi) {
        this.file_cbi = file_cbi;
    }

    @Override
    public String toString() {
        return "File{" +
                "user_id=" + user_id +
                ", file_name='" + file_name + '\'' +
                ", status=" + status +
                ", file_cbi=" + file_cbi +
                ", file_time='" + file_time + '\'' +
                '}';
    }
}

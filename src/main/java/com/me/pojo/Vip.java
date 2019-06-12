package com.me.pojo;

public class Vip {

    private int vip_id;
    private String vip_name;
    private String vip_time;

    public String getVip_price() {
        return vip_price;
    }

    public void setVip_price(String vip_price) {
        this.vip_price = vip_price;
    }

    private String vip_price;
    private int vip_down;
    private int status;

    public int getVip_id() {
        return vip_id;
    }

    public void setVip_id(int vip_id) {
        this.vip_id = vip_id;
    }

    public String getVip_name() {
        return vip_name;
    }

    public void setVip_name(String vip_name) {
        this.vip_name = vip_name;
    }

    public String getVip_time() {
        return vip_time;
    }

    public void setVip_time(String vip_time) {
        this.vip_time = vip_time;
    }

    public int getVip_down() {
        return vip_down;
    }

    public void setVip_down(int vip_down) {
        this.vip_down = vip_down;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Vip{" +
                "vip_id=" + vip_id +
                ", vip_name='" + vip_name + '\'' +
                ", vip_time='" + vip_time + '\'' +
                ", vip_price='" + vip_price + '\'' +
                ", vip_down=" + vip_down +
                ", status=" + status +
                '}';
    }
}

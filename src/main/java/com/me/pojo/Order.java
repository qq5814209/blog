package com.me.pojo;

public class Order {
    private int order_id;
    private int user_id;
    private String cbi_id;
    private String vip_id;
    private String price;
    private int cbi_number;
    private String Vip_time;
    private String order_time;
    private int status;
    private String order_number;

    public String getVip_time() {
        return Vip_time;
    }

    public void setVip_time(String vip_time) {
        Vip_time = vip_time;
    }


    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCbi_id() {
        return cbi_id;
    }

    public void setCbi_id(String cbi_id) {
        this.cbi_id = cbi_id;
    }

    public String getVip_id() {
        return vip_id;
    }

    public void setVip_id(String vip_id) {
        this.vip_id = vip_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getCbi_number() {
        return cbi_number;
    }

    public void setCbi_number(int cbi_number) {
        this.cbi_number = cbi_number;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    @Override
    public String toString() {
        return "order{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", cbi_id=" + cbi_id +
                ", vip_id=" + vip_id +
                ", price='" + price + '\'' +
                ", cbi_number=" + cbi_number +
                ", order_time='" + order_time + '\'' +
                ", status=" + status +
                ", order_number='" + order_number + '\'' +
                '}';
    }
}

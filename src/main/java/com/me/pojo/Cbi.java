package com.me.pojo;

public class Cbi {
    private int cbi_id;
    private String cbi_name;
    private int cbi_number;
    private String cbi_price;
    private int status;

    public int getCbi_id() {
        return cbi_id;
    }

    public void setCbi_id(int cbi_id) {
        this.cbi_id = cbi_id;
    }

    public String getCbi_name() {
        return cbi_name;
    }

    public void setCbi_name(String cbi_name) {
        this.cbi_name = cbi_name;
    }

    public int getCbi_number() {
        return cbi_number;
    }

    public void setCbi_number(int cbi_number) {
        this.cbi_number = cbi_number;
    }

    public String getCbi_price() {
        return cbi_price;
    }

    public void setCbi_price(String cbi_price) {
        this.cbi_price = cbi_price;
    }

    public int getStatus() {
        return status;
    }


    public void setStatus(int status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Cbi{" +
                "cbi_id=" + cbi_id +
                ", cbi_name='" + cbi_name + '\'' +
                ", cbi_number=" + cbi_number +
                ", cbi_price='" + cbi_price + '\'' +
                ", status=" + status +
                '}';
    }
}

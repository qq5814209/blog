package com.me.dto;

public class IsDownDto {
    private int file_cbi;
    private int cbis;
    private String file_name;

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

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

    @Override
    public String toString() {
        return "IsDownDto{" +
                "file_cbi=" + file_cbi +
                ", cbis=" + cbis +
                ", file_name='" + file_name + '\'' +
                '}';
    }
}

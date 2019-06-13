package com.me.dto;

public class IsDownDto {
    private int file_cbi;
    private int cbis;

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
        return "isDownDto{" +
                "file_cbi=" + file_cbi +
                ", cbis=" + cbis +
                '}';
    }
}

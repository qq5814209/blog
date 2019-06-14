package com.me.vo;

/**
 * 举报信息用
 */
public class ReportVo {
    private String reportMessage;
    private int userId;
    private int blogId;

    public String getReportMessage() {
        return reportMessage;
    }

    public void setReportMessage(String reportMessage) {
        this.reportMessage = reportMessage;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    @Override
    public String toString() {
        return "ReportVo{" +
                "reportMessage='" + reportMessage + '\'' +
                ", userId=" + userId +
                ", blogId=" + blogId +
                '}';
    }
}

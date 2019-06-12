package com.me.dto;

public class ClassificationDto {
    private int classId;         //分类id
    private int userId;          //用户名
    private String className;    //分类名称
    private int classNum;       //分类数量

    public ClassificationDto() {
    }

    public ClassificationDto(int classId, int userId, String className, int classNum) {
        this.classId = classId;
        this.userId = userId;
        this.className = className;
        this.classNum = classNum;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    @Override
    public String toString() {
        return "ClassificationDto{" +
                "classId=" + classId +
                ", userId=" + userId +
                ", className='" + className + '\'' +
                ", classNum=" + classNum +
                '}';
    }
}

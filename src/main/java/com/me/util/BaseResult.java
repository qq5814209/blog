package com.me.util;

import java.io.Serializable;

/**
 * 自定义返回结果
 */
public class BaseResult implements Serializable {
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;

    private int status;
    private String message;
    //返回成功消息
    public static BaseResult success(){
        BaseResult baseResult = createResult(STATUS_SUCCESS, "成功");
        return baseResult;
    }
    //自定义返回成功消息
    public static BaseResult success(String message){
        BaseResult baseResult = createResult(STATUS_SUCCESS, message);
        return baseResult;
    }
    //返回失败消息
    public static BaseResult fail(){
        BaseResult baseResult = createResult(STATUS_FAIL, "失败");
        return baseResult;
    }
    //自定义返回失败消息
    public static BaseResult fail(String message){
        BaseResult baseResult = createResult(STATUS_FAIL, message);
        return baseResult;
    }
    //自定义返回其他失败状态消息
    public static BaseResult fail(int status,String message){
        BaseResult baseResult = createResult(status, message);
        return baseResult;
    }
    //重构
    public static BaseResult createResult(int status,String message){
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        return baseResult;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

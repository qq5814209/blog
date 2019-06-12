package com.me.service;

import com.me.pojo.UserInfo;

/**
 * 查询用户信息、修改用户信息用
 */
public interface UserInfoService {

    /**
     * 登录
     * @param user
     * @param password
     * @return
     */
    UserInfo login(String user, String password);

    /**
     * 注册
     * @param user_name
     * @param email
     * @param password
     * @return
     */
    int regiester(String user_name, String email, String password);

    /**
     * 邮箱验证
     * @param user_id
     */
    void updateStatus(String user_id);
}

package com.me.service;

import com.me.pojo.UserInfo;
import com.me.vo.UserInfoVo;

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
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    UserInfoVo selectUserInfo(int userId);
}

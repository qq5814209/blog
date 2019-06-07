package com.me.mapper;

import com.me.pojo.UserInfo;

/**
 * 操作 userInfo 表
 */
public interface UserInfoMapper {

    /**
     * 根据用户 id 查询用户信息
     * @param userId
     * @return
     */
    UserInfo selectUserInfo(int userId);
}

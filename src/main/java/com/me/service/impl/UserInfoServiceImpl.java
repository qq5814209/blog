package com.me.service.impl;

import com.me.mapper.UserInfoMapper;
import com.me.pojo.UserInfo;
import com.me.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 查询用户信息、修改用户信息用
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    /**
     * 登录
     * @param user
     * @param password
     * @return
     */
    public UserInfo login(String user, String password) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUser_name(user);
        userInfo.setPassword(password);
        return userInfoMapper.login(userInfo);
    }


}

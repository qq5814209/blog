package com.me.service.impl;

import com.me.mapper.UserInfoMapper;
import com.me.pojo.UserInfo;
import com.me.service.UserInfoService;
import com.me.vo.UserInfoVo;
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
        if(user.contains("@")){
            userInfo.setEmail(user); //邮箱登录
        }else {
            userInfo.setUser_name(user); //账号登录
        }
        userInfo.setPassword(password);
        return userInfoMapper.login(userInfo);
    }

    /**
     * 注册
     * @param user_name
     * @param email
     * @param password
     * @return
     */
    public int regiester(String user_name, String email, String password) {
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setUser_name(user_name);
        userInfoVo.setEmail(email);
        userInfoVo.setPassword(password);
        return userInfoMapper.regiester(userInfoVo);
    }


}

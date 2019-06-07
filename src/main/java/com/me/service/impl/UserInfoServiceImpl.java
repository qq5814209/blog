package com.me.service.impl;

import com.me.mapper.CareMapper;
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

    @Autowired
    CareMapper careMapper;
    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    public UserInfoVo selectUserInfo(int userId) {

        UserInfo userInfo = userInfoMapper.selectUserInfo(userId);
        System.out.println(userInfo);
        int fans = careMapper.selectCareByFans(userId);
        int attentions = careMapper.selectCareByAttentions(userId);

        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setUserInfo(userInfo);
        userInfoVo.setFans(fans);
        userInfoVo.setAttentions(attentions);

        return userInfoVo;
    }
}

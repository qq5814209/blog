package com.me.mapper;

import com.me.pojo.UserInfo;
import com.me.vo.UserInfoVo;

/**
 * 操作 userInfo 表
 */
public interface UserInfoMapper {

    /**
     * 登录
     * @param userInfo
     * @return
     */
    UserInfo login(UserInfo userInfo);

    /**
     * 注册
     * @param userInfoVo
     * @return
     */
    int regiester(UserInfoVo userInfoVo);
}

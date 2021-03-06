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

    /**
     * 获取刚注册最新的id
     * @return
     */
    int selectMaxId();

    /**
     * 新用户注册邮箱激活
     * @param userid
     */
    void updateStatus(int userid);


    /**
     * 判断新注册账号是否存在
     * @param user_name
     * @return
     */
    UserInfo user_nameIsExist(String user_name);

    public UserInfo cheUsername(String user_name);

}

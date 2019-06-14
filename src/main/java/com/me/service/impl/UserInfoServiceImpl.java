package com.me.service.impl;

import com.me.mapper.UserInfoMapper;
import com.me.pojo.UserInfo;
import com.me.service.UserInfoService;
import com.me.util.BaseResult;
import com.me.util.SendJMail;
import com.me.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 查询用户信息、修改用户信息用
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 登录
     * @param user
     * @param password
     * @return
     */
    public UserInfo login(String user, String password) {
        UserInfo userinfo = new UserInfo();
        if(user.contains("@")){
            userinfo.setEmail(user); //邮箱登录
        }else {
            userinfo.setUser_name(user); //账号登录
        }
        userinfo.setPassword(password);
        return userInfoMapper.login(userinfo);
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
        //插入新数据
        int i = userInfoMapper.regiester(userInfoVo);
        //查询最新user_id
        int newUserId = userInfoMapper.selectMaxId();
        //发送邮件
        String emailMsg = "注册成功，请<a href='http://localhost:8080/activate?user_id="+newUserId+"'>激活</a>后登录";
        SendJMail.sendMail(email, emailMsg);
        return i;
    }

    /**
     * 新用户注册邮箱激活
     * @param user_id
     */
    public void updateStatus(String user_id) {
        int userid = Integer.parseInt(user_id);
        userInfoMapper.updateStatus(userid);
    }

    @Override
    public boolean cheUsername(String user_name) {

        UserInfo userInfo = userInfoMapper.cheUsername(user_name);
        if (userInfo==null){
            return true;
        }
        return false;
    }

}

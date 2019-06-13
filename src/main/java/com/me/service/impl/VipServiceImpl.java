package com.me.service.impl;

import com.me.mapper.VipMapper;
import com.me.pojo.UserInfo;
import com.me.pojo.Vip;
import com.me.service.VipService;
import com.me.vo.IsVipVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class VipServiceImpl implements VipService {

    @Autowired
    VipMapper vipMapper;

    /**
     * 获取vip套餐
     * @param vip
     * @return
     */
    public List<Vip> getVip(Vip vip) {
        return vipMapper.getVip(vip);
    }


    /**
     * 查看是否为 Vip用户
     * @param session
     * @return
     */
    public Object isVip(HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        IsVipVo vip = vipMapper.isVip(userInfo);
        if (vip!=null){
            return vip;
        }
        return false;
    }
}

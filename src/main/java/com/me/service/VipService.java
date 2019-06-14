package com.me.service;

import com.me.pojo.UserInfo;
import com.me.pojo.Vip;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface VipService {

    public List<Vip> getVip(Vip vip);

    public Object isVip(HttpSession session);

    public Object isVipById(UserInfo userInfo);

}

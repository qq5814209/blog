package com.me.mapper;

import com.me.dto.UserVipDto;
import com.me.pojo.Vip;

import java.util.List;

public interface VipMapper {

    /**
     * 获取VIP套餐
     * @param vip
     * @return
     */
    public List<Vip> getVip(Vip vip);

    /**
     * 获取指定的vip套餐
     * @param vipId
     * @return
     */
    public Vip getVipById(String vipId);

    /**
     * 用户与会员表
     * @param userVip
     */
    public void setUserVip(UserVipDto userVip);

}

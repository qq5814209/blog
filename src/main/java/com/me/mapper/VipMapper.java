package com.me.mapper;

import com.me.dto.UserVipDto;
import com.me.pojo.UserInfo;
import com.me.pojo.Vip;
import com.me.vo.IsVipVo;

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


    /**
     * 查看是否为会员身份
     * @param userInfo
     * @return
     */
    public IsVipVo isVip(UserInfo userInfo);

    /**
     * 根据用户id查是否为会员
     * @param userInfo
     * @return
     */
    public Object isVipById(UserInfo userInfo);

}

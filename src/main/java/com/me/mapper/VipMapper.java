package com.me.mapper;

import com.me.pojo.Vip;

import java.util.List;

public interface VipMapper {


    public List<Vip> getVip(Vip vip);

    public Vip getVipById(String vipId);
}
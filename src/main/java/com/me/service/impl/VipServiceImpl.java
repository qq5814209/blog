package com.me.service.impl;

import com.me.mapper.VipMapper;
import com.me.pojo.Vip;
import com.me.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VipServiceImpl implements VipService {

    @Autowired
    VipMapper vipMapper;


    public List<Vip> getVip(Vip vip) {
        return vipMapper.getVip(vip);
    }
}

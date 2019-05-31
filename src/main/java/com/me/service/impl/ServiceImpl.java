package com.me.service.impl;

import com.me.mapper.Mapper;
import com.me.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    @Autowired
    Mapper mapper;
    public String selectAll() {
        return "success";
    }
}

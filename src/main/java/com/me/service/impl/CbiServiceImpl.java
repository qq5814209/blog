package com.me.service.impl;

import com.me.mapper.CbiMapper;
import com.me.pojo.Cbi;
import com.me.service.CbiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CbiServiceImpl implements CbiService {
    @Autowired
    CbiMapper cbiMapper;



    /**
     * 获取C币套餐
     * @param cbi
     * @return
     */
    public List<Cbi> getCbi(Cbi cbi) {
        return cbiMapper.getCbi(cbi);
    }

}

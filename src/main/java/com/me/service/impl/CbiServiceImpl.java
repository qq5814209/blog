package com.me.service.impl;

import com.me.dto.IsDownDto;
import com.me.mapper.CbiMapper;
import com.me.pojo.Cbi;
import com.me.pojo.Order;
import com.me.pojo.UserInfo;
import com.me.service.CbiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Override
    public UserInfo getCbiById(HttpSession session) {
        UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
        return cbiMapper.getUserCbi(userInfo);
    }

    @Override
    public Object getCbiXiao(HttpSession session) {
        UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
        return cbiMapper.getCbiXiao(userInfo);
    }


}

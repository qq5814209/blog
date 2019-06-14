package com.me.service;

import com.me.pojo.Cbi;
import com.me.pojo.Order;
import com.me.pojo.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface CbiService {
    public List<Cbi> getCbi(Cbi cbi);

    public UserInfo getCbiById(HttpSession session);
}

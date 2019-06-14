package com.me.service;


import com.me.pojo.Cbi;
import com.me.pojo.Order;
import com.me.pojo.Vip;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface OrderService {

   public void SetOrder(HttpServletRequest request, HttpServletResponse response);


   public void upOrder(HttpServletRequest request, HttpServletResponse response);

    public Object getOrderBy(HttpSession session);
}

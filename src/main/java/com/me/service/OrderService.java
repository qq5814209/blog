package com.me.service;


import com.me.pojo.Cbi;
import com.me.pojo.Order;
import com.me.pojo.Vip;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface OrderService {

   public Object SetOrder(HttpServletRequest request, HttpServletResponse response);


}

package com.me.controller;


import com.me.config.PayProperties;

import com.me.pojo.Order;
import com.me.pojo.UserInfo;
import com.me.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class OrderController {

    @Autowired
    OrderService orderService;


    /**
     * 创建订单后支付
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value ="setOrder",method = RequestMethod.GET)
    public void setOrder(HttpServletRequest request, HttpServletResponse response) {
        orderService.SetOrder(request,response);
        return;
    }

    /**
     * 正常支付后请求
     * @param request
     * @param response
     */
    @RequestMapping(value ="callback",method = RequestMethod.GET)
    public void callback( HttpServletRequest request, HttpServletResponse response){
       orderService.upOrder(request,response);

    }

    /**
     * 根据用户查订单
     * @param session
     */
    @ResponseBody
    @RequestMapping(value ="getOrderBy",method = RequestMethod.GET)
    public Object getOrderBy(HttpSession session){
        return orderService.getOrderBy(session);

    }




    /**
     * 交易异常后请求
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "callback_nsync")
    public void callback_nsync(HttpServletRequest request,HttpServletResponse response){

        try {
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write("<h1>支付失败，请重试！</h1>");
            response.getWriter().write("<br/><a href='vip_center.html'>前往支付页面</a>");
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

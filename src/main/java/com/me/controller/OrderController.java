package com.me.controller;


import com.me.config.PayProperties;

import com.me.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    PayProperties payProperties;




    @RequestMapping(value ="setOrder",method = RequestMethod.GET)
    public Object setOrder(HttpServletRequest request, HttpServletResponse response) {
        return orderService.SetOrder(request,response);
    }


    @RequestMapping(value ="callback",method = RequestMethod.GET)
    public void callback( HttpServletRequest request, HttpServletResponse response){
        System.out.println("---------支付正常-------------");

        try {
            response.setContentType("text/html; charset=utf-8");
            Enumeration enu = request.getParameterNames();
            while(enu.hasMoreElements()){
                String paraName=(String)enu.nextElement();
                response.getWriter().write(paraName+": "+request.getParameter(paraName)+"<br>");
            }
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @ResponseBody
    @RequestMapping(value = "callback_nsync")
    public void callback_nsync(HttpServletRequest request,HttpServletResponse response){
        System.out.println("-----------------------------------");
        try {
            System.out.println("错误错误错误错误错误错误");
            response.setContentType("text/html; charset=utf-8");
            Enumeration enu = request.getParameterNames();
            while(enu.hasMoreElements()){
                String paraName=(String)enu.nextElement();
                System.out.println(paraName+": "+request.getParameter(paraName));
            }
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("错误完完完完");


    }



}

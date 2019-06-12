package com.me.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.me.config.PayProperties;
import com.me.dto.UserVipDto;
import com.me.mapper.CbiMapper;
import com.me.mapper.OrderMapper;
import com.me.mapper.VipMapper;
import com.me.pojo.Cbi;
import com.me.pojo.Order;
import com.me.pojo.UserInfo;
import com.me.pojo.Vip;
import com.me.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    PayProperties payProperties;

    @Autowired
    AlipayClient alipayClient;

    @Autowired
    CbiMapper cbiMapper;

    @Autowired
    VipMapper vipMapper;


    /**
     * 创建未支付的订单
     * @param request
     * @param response
     * @return
     */
    public Object SetOrder(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write(getwayPay(request));
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return "订单创建完成";
    }

    /**
     * 支付后的订单状态修改
     * @param request
     * @param response
     */
    public void upOrder(HttpServletRequest request, HttpServletResponse response) {

        Order order =new Order();
        UserVipDto userVip =new UserVipDto();
        Enumeration enu = request.getParameterNames();

        String out_trade_no = request.getParameter("out_trade_no");
        System.out.println("订单号为："+out_trade_no);
        order.setOrder_number(out_trade_no);
        order.setStatus(1);
        orderMapper.upOrder(order);
        Order order2 = orderMapper.getOrderByNum(order);
        System.out.println("订单实体为："+order2);
        if (order2.getVip_id()!=null){
            userVip.setVip_id(order2.getVip_id());
            userVip.setEnd_time(order2.getVip_time());
            userVip.setUser_id(order2.getUser_id());
            vipMapper.setUserVip(userVip);
        }

        try {
            response.sendRedirect(request.getContextPath()+"/vip_center.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getwayPay(HttpServletRequest request) {
        Order order = new Order();
        Date date = new Date();
        Random ra =new Random();

        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        StringBuffer sb = new StringBuffer();
        String price=null;

        String productCode = "FAST_INSTANT_TRADE_PAY";

        UserInfo userInfo =(UserInfo)request.getSession().getAttribute("userInfo");
        long time = date.getTime();
        sb.append(time);
        for (int i=0;i<4;i++){
            sb.append(ra.nextInt(10)+1);
        }
        String cbi_id = request.getParameter("cbi_id");
        String vip_id = request.getParameter("vip_id");
        System.out.println("cbi_id:"+cbi_id);
        System.out.println("vip_id:"+vip_id);
        if (cbi_id!=null){
            Cbi cbi1 = cbiMapper.getCbiById(cbi_id);
            price = cbi1.getCbi_price();
            order.setCbi_number(cbi1.getCbi_number());
        }else if (vip_id!=null){
            Vip vip1 = vipMapper.getVipById(vip_id);
            price = vip1.getVip_price();
            order.setVip_time(vip1.getVip_time());
        }
        model.setOutTradeNo(sb.toString());
        model.setSubject("CSDN充值");
        model.setTotalAmount(price);
        model.setBody("页面充值，共"+price+"元");
        model.setProductCode(productCode);

        AlipayTradePagePayRequest pagePayRequest = new AlipayTradePagePayRequest();
        pagePayRequest.setReturnUrl(payProperties.getReturnUrl());
        pagePayRequest.setNotifyUrl(payProperties.getNotifyUrl());
        pagePayRequest.setBizModel(model);

        order.setUser_id(userInfo.getUser_id());
        order.setCbi_id(cbi_id);
        order.setVip_id(vip_id);
        order.setPrice(price);
        order.setOrder_number(sb.toString());
        orderMapper.setOrder(order);

        // 调用SDK生成表单, 并直接将完整的表单html输出到页面
        String retStr = null;
        try {
            retStr = alipayClient.pageExecute(pagePayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return retStr;
    }
}

package com.me.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.me.config.PayProperties;
import com.me.mapper.CbiMapper;
import com.me.mapper.OrderMapper;
import com.me.mapper.VipMapper;
import com.me.pojo.Cbi;
import com.me.pojo.Order;
import com.me.pojo.Vip;
import com.me.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

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





    public Object SetOrder(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write(getwayPay(request));
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return null;
    }




    public String getwayPay(HttpServletRequest request) {
        Order order = new Order();
        Date date = new Date();
        Random ra =new Random();
        StringBuffer sb = new StringBuffer();


        String productCode = "FAST_INSTANT_TRADE_PAY";
        String price=null;
        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        long time = date.getTime();
        sb.append(time);
        for (int i=0;i<4;i++){
            sb.append(ra.nextInt(10)+1);
        }
        String cbi_id = request.getParameter("cbi_id");
        String vip_id = request.getParameter("vip_id");
        System.out.println("cbi_id:==="+cbi_id);
        System.out.println("vip_id:==="+vip_id);
        if (cbi_id!=null||!cbi_id.equals("")){
            Cbi cbi1 = cbiMapper.getCbiById(cbi_id);
            price = cbi1.getCbi_price();
            order.setCbi_number(cbi1.getCbi_number());
        }else if (vip_id!=null||!vip_id.equals("")){
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

package com.me.mapper;

import com.me.pojo.Order;
import com.me.pojo.UserInfo;

import java.util.List;

public interface OrderMapper {
    /**
     * 创建订单
     * @param order
     * @return
     */
    public int setOrder(Order order);

    /**
     * 更改订单状态
     * @param order
     */
    public void upOrder(Order order);


    /**
     * 根据订单号获取订单
     * @param order
     * @return
     */
    public Order getOrderByNum(Order order);

    /**
     * 根据用户查订单
     * @param userInfo
     * @return
     */
    List<Order> getOrderBy(UserInfo userInfo);
}

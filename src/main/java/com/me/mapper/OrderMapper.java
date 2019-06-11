package com.me.mapper;

import com.me.pojo.Order;

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


}

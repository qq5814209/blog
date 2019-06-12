package com.me.mapper;

import com.me.pojo.Order;

public interface OrderMapper {
    public int setOrder(Order order);

    public void upOrder(Order order);

    public Order getOrderByNum(Order order);


}

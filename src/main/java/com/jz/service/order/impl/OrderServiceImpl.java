package com.jz.service.order.impl;

import com.jz.mapper.order.OrderMapper;
import com.jz.pojo.Order;
import com.jz.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> findUnfinshedOrder() {
        return orderMapper.findUnfinshedOrder();
    }

    @Override
    public List<Order> findAllOrder() {
        return orderMapper.findAllOrder();
    }

    @Override
    public List<Order> findTodayFinshedOrders() {
        return orderMapper.findTodayFinshedOrders();
    }


}

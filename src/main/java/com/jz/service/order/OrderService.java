package com.jz.service.order;

import com.jz.pojo.Order;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.List;

public interface OrderService {

    public List<Order> findUnfinshedOrder();

    public List<Order> findAllOrder();

    public List<Order> findTodayFinshedOrders();
}

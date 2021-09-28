package com.jz.mapper.order;

import com.jz.pojo.Order;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.List;

@Repository
public interface OrderMapper {

    @Select("SELECT * FROM jizaadmin.order WHERE status = '未完成'")
    public List<Order> findUnfinshedOrder();

    @Select("SELECT * FROM jizaadmin.order WHERE status = '已完成'")
    public List<Order> findTodayFinshedOrders();

    @Select("SELECT * FROM jizaadmin.order")
    public List<Order> findAllOrder();
}

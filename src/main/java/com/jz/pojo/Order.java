package com.jz.pojo;

import lombok.Data;

@Data
public class Order {

    private Integer id;
    private String orderId;
    private Integer tableNumber;

    public Integer getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }

    private String orderName;
    private Integer price;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order() {
    }

    public Order(Integer id, String orderId, String orderName, Integer price, String status) {
        this.id = id;
        this.orderId = orderId;
        this.orderName = orderName;
        this.price = price;
        this.status = status;
    }
}

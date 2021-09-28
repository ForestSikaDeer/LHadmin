package com.jz.controller.order;

import com.jz.pojo.Order;
import com.jz.pojo.TodayOrder;
import com.jz.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/findUnfinshedOrder.action")
    public String findUnfinshedOrder(Model model) {
        int todayOrderSum = 0;
        int todayAlreadySum = 0;
        int todayUnfinishedSum = 0;
        int todayPrice = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        long nowTime = System.currentTimeMillis();
        String formatNowTime = sdf.format(nowTime);
        List<Order> unfinshedOrders = orderService.findUnfinshedOrder();
        List<Order> orders = orderService.findAllOrder();
        List<Order> todayFinshedOrders = orderService.findTodayFinshedOrders();
        for (Order unfinshedOrder : unfinshedOrders) {
            if (formatNowTime.equals(unfinshedOrder.getOrderId().substring(0,8))) {
                todayUnfinishedSum++;
            }
        }
        for (Order order : orders) {
            if (formatNowTime.equals(order.getOrderId().substring(0,8))) {
                todayOrderSum++;
            }
        }
        for (Order todayFinshedOrder : todayFinshedOrders) {
            if (formatNowTime.equals(todayFinshedOrder.getOrderId().substring(0,8))) {
                todayPrice += todayFinshedOrder.getPrice();
            }
        }
        todayAlreadySum = todayOrderSum - todayUnfinishedSum;
        model.addAttribute("todayOrderSum", todayOrderSum);
        model.addAttribute("todayAlreadySum", todayAlreadySum);
        model.addAttribute("todayUnfinishedSum", todayUnfinishedSum);
        model.addAttribute("todayPrice", todayPrice);
        model.addAttribute("unfinshedOrders", unfinshedOrders);
        return "unfinshed";
    }

    @GetMapping("/getAllOrders.action")
    public String findAllOrders(Model model) {
        List<Order> orders = orderService.findAllOrder();
        model.addAttribute("orders", orders);
        return "allOrders";
    }

    @GetMapping("/findTodayAllOrders.action")
    public String findTodayAllOrders(Model model) {
        List<Order> todayOrders = new ArrayList<>();
        List<Order> orders = orderService.findAllOrder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        long nowTime = System.currentTimeMillis();
        String formatNowTime = sdf.format(nowTime);
        for (Order order : orders) {
            String orderId = order.getOrderId().substring(0, 8);
            if (orderId.equals(formatNowTime)) {
                todayOrders.add(order);
            }
        }

        model.addAttribute("todayAllOrders", todayOrders);
        return "todayAllOrders";
    }

    @GetMapping("/todayFinshedAllOrders.action")
    public String todayFinshedAllOrders(Model model) {
        List<Order> todayOrders = new ArrayList<>();
        List<Order> orders = orderService.findTodayFinshedOrders();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        long nowTime = System.currentTimeMillis();
        String formatNowTime = sdf.format(nowTime);
        for (Order order : orders) {
            String orderId = order.getOrderId().substring(0, 8);
            if (orderId.equals(formatNowTime)) {
                todayOrders.add(order);
            }
        }
        model.addAttribute("todayAllOrders", todayOrders);
        return "todayFinshedAllOrders";
    }

    @GetMapping("/todayUnfinshedAllOrders.action")
    public String todayUnfinshedAllOrders(Model model) {
        List<Order> todayOrders = new ArrayList<>();
        List<Order> orders = orderService.findUnfinshedOrder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        long nowTime = System.currentTimeMillis();
        String formatNowTime = sdf.format(nowTime);
        for (Order order : orders) {
            System.out.println(order.getStatus());
            String orderId = order.getOrderId().substring(0, 8);
            if (orderId.equals(formatNowTime)) {
                todayOrders.add(order);
            }
        }
        model.addAttribute("todayAllOrders", todayOrders);
        return "todayUnfinshedAllOrders";
    }
}

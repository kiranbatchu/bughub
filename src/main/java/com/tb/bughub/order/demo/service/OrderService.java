package com.tb.bughub.order.demo.service;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

import com.tb.bughub.order.demo.domain.Menu;
import com.tb.bughub.order.demo.domain.OrderRequest;
import com.tb.bughub.order.demo.domain.OrderResponse;
import com.tb.bughub.order.demo.model.MenuItem;
import com.tb.bughub.order.demo.model.Order;
import com.tb.bughub.order.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    @Autowired
    MenuService menuService;

    public OrderResponse createOrder(OrderRequest orderRequest)
    {
        int totalPriceWithTips = orderRequest.getTip();
        Order order = new Order();
        for ( String menuId : orderRequest.getMenuItem()) {
            Menu menu = menuService.getItemsById(menuId);
            totalPriceWithTips += menu.getPrice();
             MenuItem menuItem = new MenuItem();
             menuItem.setId(menuId);
             menuItem.setName(menu.getName());
             menuItem.setOrder(order);
             order.getMenuItems().add(menuItem);
        }

        order.setOrderId(UUID.randomUUID());
        order.setOrderTime(Timestamp.from(Instant.now()));
        order.setExprectedDeliveryTime(Timestamp.from(Instant.now().plus( 1 , ChronoUnit.HOURS )));
        order.setTotalPrice(Integer.toString(totalPriceWithTips));
        order.setUserId(orderRequest.getUserId());
        order.setRestuarantId(orderRequest.getRestuarantId());
        order.setOrderDate(new Date(new java.util.Date().getTime()));
        repository.save(order);
       return getOrderResponse(order);
    }

    private OrderResponse getOrderResponse(Order order){
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setExpectedDeliveryTime(order.getExprectedDeliveryTime().toInstant());
        orderResponse.setOrderId(order.getOrderId().toString());
        orderResponse.setTotalPrice(order.getTotalPrice());
        orderResponse.setOrderTime(order.getOrderTime().toInstant());
        return orderResponse;
    }
}
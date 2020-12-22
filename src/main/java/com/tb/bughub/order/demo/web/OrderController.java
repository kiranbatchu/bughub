package com.tb.bughub.order.demo.web;

import java.time.Instant;
import java.util.List;

import com.tb.bughub.order.demo.domain.OrderRequest;
import com.tb.bughub.order.demo.domain.OrderResponse;
import com.tb.bughub.order.demo.model.Order;
import com.tb.bughub.order.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController
{
    @Autowired
    OrderService service;

    @RequestMapping(path="/createOrder")
    @PostMapping
    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
        return service.createOrder(orderRequest);
    }

    @RequestMapping(path="/getOrder")
    @GetMapping
    public OrderRequest getOrder(OrderRequest orderRequest) {
        return orderRequest;
    }
}
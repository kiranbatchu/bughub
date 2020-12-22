package com.tb.bughub.order.demo.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class OrderResponse {

    @JsonProperty("order_id")
    private String orderId;
    @JsonProperty("total_price")
    private String totalPrice;
    @JsonProperty("order_time")
    private Instant orderTime;
    @JsonProperty("exprected_delivery_time")
    private Instant expectedDeliveryTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Instant getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Instant orderTime) {
        this.orderTime = orderTime;
    }

    public Instant getExpectedDeliveryTime() {
        return expectedDeliveryTime;
    }

    public void setExpectedDeliveryTime(Instant expectedDeliveryTime) {
        this.expectedDeliveryTime = expectedDeliveryTime;
    }
}

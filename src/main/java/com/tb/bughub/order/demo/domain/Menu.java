package com.tb.bughub.order.demo.domain;

public class Menu {

    private String id;
    private String name;
    private Integer price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

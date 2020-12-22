package com.tb.bughub.order.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OrderRequest {

    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("restuarant_id")
    private String restuarantId;
    @JsonProperty("menu_item")
    private List<String> menuItem;
    @JsonProperty("tip")
    private Integer tip;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRestuarantId() {
        return restuarantId;
    }

    public void setRestuarantId(String restuarantId) {
        this.restuarantId = restuarantId;
    }

    public List<String> getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(List<String> menuItem) {
        this.menuItem = menuItem;
    }

    public Integer getTip() {
        return tip;
    }

    public void setTip(Integer tip) {
        this.tip = tip;
    }

}

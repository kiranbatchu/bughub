package com.tb.bughub.order.demo.model;

import com.tb.bughub.order.demo.model.MenuItem;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

@Entity
@Table(name="ORDER_DEL")
public class Order {

    @Id
	@Column(name="order_id")
    private UUID orderId ;
    
    @Column(name="user_id")
    private String userId;
    
    @Column(name="restuarant_id")
    private String restuarantId;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER , mappedBy = "order")
	private Set<MenuItem> menuItems = new HashSet<MenuItem>();
    
    @Column(name="order_date", nullable=false, length=200)
    private Date orderDate;

	@Column(name="total_price", nullable=false, length=200)
	private String totalPrice;

	@Column(name="order_time", nullable=false, length=200)
	private Timestamp orderTime;

	@Column(name="ex_delivery_time", nullable=false, length=200)
	private Timestamp exprectedDeliveryTime;

	public UUID getOrderId() {
		return orderId;
	}

	public void setOrderId(UUID orderId) {
		this.orderId = orderId;
	}

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

	public Set<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(Set<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public Timestamp getExprectedDeliveryTime() {
		return exprectedDeliveryTime;
	}

	public void setExprectedDeliveryTime(Timestamp exprectedDeliveryTime) {
		this.exprectedDeliveryTime = exprectedDeliveryTime;
	}
}
package com.ECommerce.ScratchCard.Entity;

import java.math.BigDecimal;
import java.util.List;

public class Order {
	
	private int orderID;
	private User user;
    private List<Item> items;
    private BigDecimal totalAmount;
    private String orderRef;
    
	
	
    public int getOrderID() {
		return orderID;
	}



	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public List<Item> getItems() {
		return items;
	}



	public void setItems(List<Item> items) {
		this.items = items;
	}



	public BigDecimal getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}



	public String getOrderRef() {
		return orderRef;
	}



	public void setOrderRef(String orderRef) {
		this.orderRef = orderRef;
	}



	

    public Order(int orderID, User user, List<Item> items, BigDecimal totalAmount, String orderRef) {
		super();
		this.orderID = orderID;
		this.user = user;
		this.items = items;
		this.totalAmount = totalAmount;
		this.orderRef = orderRef;
	}
	
    }
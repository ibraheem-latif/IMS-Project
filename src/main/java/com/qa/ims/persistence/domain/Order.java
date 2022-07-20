package com.qa.ims.persistence.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
	
	private Long orderId;
	private String orderDate;
	private Long customerId;
	private List<Item>orderItems =new ArrayList<>();
	
	
	public Order() {}


	public Order(Long orderId, String orderDate, Long customerId, List<Item> orderItems) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.orderItems = orderItems;
	}
	
	public Order(Long orderId, String orderDate, Long customerId) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerId = customerId;

	}
	
	public Order(Long customerId,String date) {
		super();
		this.orderDate = date;
		this.customerId = customerId;

	}


	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public String getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}


	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public List<Item> getOrderItems() {
		return orderItems;
	}


	public void setOrderItems(List<Item> orderItems) {
		this.orderItems = orderItems;
	}


	@Override
	public String toString() {
		double orderTotal =0;
		for (Item i : orderItems)
			orderTotal += i.getItemPrice();
		return "order ID:" + orderId + " order date:" + orderDate + " customer ID:" + customerId + ", items ordered:"
				+ orderItems + "\nOrder Total: £"+orderTotal;
		
	}


	@Override
	public int hashCode() {
		return Objects.hash(customerId, orderDate, orderId, orderItems);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(orderDate, other.orderDate)
				&& Objects.equals(orderId, other.orderId) && Objects.equals(orderItems, other.orderItems);
	}
	
	
	
}
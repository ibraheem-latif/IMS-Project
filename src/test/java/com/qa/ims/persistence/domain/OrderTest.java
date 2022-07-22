package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class OrderTest {
	
	Order order;
	Item item;
	Long customerId = (long) 1;
	Long orderId = (long) 2;
	String orderDate = "2022/12/25";
	List<Item> orderItems = new ArrayList<Item>();

	
	@Test
	public void toStringTest() {
		order = new Order(orderId, orderDate, customerId, orderItems);
		double orderTotal =0;
		for (Item i : orderItems)
			orderTotal += i.getItemPrice();
		assertEquals(("order ID:" + orderId + " order date:" + orderDate + " customer ID:" + customerId + ", items ordered:"
				+ orderItems + "\nOrder Total: £"+orderTotal),order.toString());

	}

	@Test
	public void constructorOne() {
		order = new Order(orderId, orderDate, customerId, orderItems);
	}

	@Test
	public void constructorTwo() {
		order = new Order(orderId, orderDate, customerId);
	}
	
	@Test
	public void ContructorThree() {
		order = new Order(customerId, orderDate);
	}


	@Test
	public void testGetCustomerId() {
		order = new Order(orderId, orderDate, customerId, orderItems);
		assertEquals(customerId, order.getCustomerId());
	}
	

	@Test
	public void testGetOrderId() {
		order = new Order(orderId, orderDate, customerId, orderItems);
		assertEquals(orderId, order.getOrderId());
	}
	
	@Test
	public void testGetOrderDate() {
		order = new Order(orderId, orderDate, customerId, orderItems);
		assertEquals(orderDate, order.getOrderDate());
	}

	@Test
	public void testGetOrderItems() {
		order = new Order(orderId, orderDate, customerId, orderItems);
		assertEquals(orderItems, order.getOrderItems());
	}

	@Test
	public void testSetCustomerId() {
		order = new Order(orderId, orderDate, customerId, orderItems);
		order.setCustomerId((long) 12);
		assertEquals((long) 12, order.getCustomerId(), 0.0001);

	}

	@Test
	public void testSetOrderId() {
		order = new Order(orderId, orderDate, customerId, orderItems);
		order.setOrderId((long) 21);
		assertEquals((long) 21, order.getOrderId(), 0.0001);

	}
	
	@Test
	public void testSetOrderDate() {
		order = new Order(orderId, orderDate, customerId, orderItems);
		order.setOrderDate("2002/08/11");
		assertEquals("2002/08/11", order.getOrderDate());

	}

	@Test
	public void testSetOrderItems() {
		order = new Order(orderId, orderDate, customerId, orderItems);
		order.setOrderItems(orderItems);
		assertEquals(orderItems, order.getOrderItems());

	}
	
	@Test
	public void testHashCodeAndEquals() {
		Order a = new Order((long) 9, "2022/12/24");
		Order b = new Order((long) 4, "2021/02/12");
		
		Assert.assertFalse(a.equals(b) && b.equals(a));
		Assert.assertFalse(a.hashCode() == b.hashCode());
	}


}

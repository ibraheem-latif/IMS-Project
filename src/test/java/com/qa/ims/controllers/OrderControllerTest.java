package com.qa.ims.controllers;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)

public class OrderControllerTest {
	
	@Mock
	private Utils utils;

	@Mock
	private OrderDAO DAO;

	@InjectMocks
	private OrderController controller;
	
	@Test
	public void testCreate() {
		final long customerId = (long) 4;
		final String orderDate = "2012/12/30";
		final Order order = new Order(customerId,orderDate);

		Mockito.when(utils.getLong()).thenReturn(customerId);
		Mockito.when(utils.getString()).thenReturn(orderDate);
		Mockito.when(DAO.create(order)).thenReturn(order);

		assertEquals(order, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(DAO, Mockito.times(1)).create(order);

	}
	
	@Test
	public void testReadAll() {
		final long customerId = (long) 4;
		final String orderDate = "2012/12/30";
		List<Order> order = new ArrayList<>();
		order.add(new Order(customerId,orderDate));

		Mockito.when(DAO.readAll()).thenReturn(order);

		assertEquals(order, controller.readAll());

		Mockito.verify(DAO, Mockito.times(1)).readAll();
	}
	

	
	@Test
	public void testUpdate() {
		final Long orderId = 1L, customerId = 2L;
		final String orderDate = "2011/12/30";

		final Order order = new Order(orderId, orderDate, customerId);

		Mockito.when(utils.getLong()).thenReturn(orderId, customerId);
		Mockito.when(utils.getString()).thenReturn(orderDate);
		Mockito.when(DAO.update(order)).thenReturn(order);
		
		assertEquals(order, controller.update());
		
		Mockito.verify(this.utils, Mockito.times(2)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(this.DAO, Mockito.times(1)).update(order);
		
	}
	
	@Test
	public void testDelete() {
		final long customerId = (long) 4;
		final String orderDate = "2012/12/30";

		Mockito.when(utils.getLong()).thenReturn(customerId);
		Mockito.when(utils.getString()).thenReturn(orderDate);
		Mockito.when(DAO.delete(customerId)).thenReturn(1);

		assertEquals(1, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(DAO, Mockito.times(1)).delete(customerId);
	}
	
	
//	@Test
//	public void testAddItem() {
//		final Long orderId = 1L, itemId = 3L;
//		
//		int testMe = 1;
//		Mockito.when(utils.getLong()).thenReturn(orderId, itemId);
//		Mockito.when(DAO.addItem(orderId, itemId)).thenReturn(1, 1);
//		
//		assertEquals(testMe, controller.update());
//		
//		Mockito.verify(this.utils, Mockito.times(2)).getLong();
//		Mockito.verify(this.DAO, Mockito.times(1)).addItem(orderId, itemId);
//	}
	
//	@Test
//	public void testDeleteItem() {
//		final Long orderId = 5L, itemId = 6L;
//		int testMe = 1;
//		Mockito.when(utils.getLong()).thenReturn(orderId, itemId);
//		Mockito.when(DAO.deleteItem(orderId, itemId)).thenReturn(1);
//		
//		assertEquals(testMe, controller.delete());
//		
//		Mockito.verify(this.utils, Mockito.times(2)).getLong();
//		Mockito.verify(this.DAO, Mockito.times(1)).deleteItem(orderId, itemId);
//	}

}

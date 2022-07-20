package com.qa.ims.controller;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	private OrderDAO orderDAO;
	private Utils utils;
	
	
	

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for(Order order: orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Enter a customer ID");
		Long customerId = utils.getLong();
		LOGGER.info("Enter an order date, of format:yyyy/MM/dd");
		String date = utils.getString();
		Order order = orderDAO.create(new Order(customerId,date));
		LOGGER.info("Order created");
		return null;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you wish to update");
		Long orderId = utils.getLong();
		LOGGER.info("Would you like to add to, or remove an item from an order?");
		String addOrDelete = utils.getString();
		if (addOrDelete.equals("add")) {
			LOGGER.info("Please enter the id of the item you wish to add to the order");
			Long itemId = utils.getLong();			
			Order order = orderDAO.addItem(orderId, itemId);
			LOGGER.info("Order Updated");
			return order;
		} else if (addOrDelete.equals("remove")) {
			LOGGER.info("Please enter the id of the item you wish to remove from the order");
			Long itemId = utils.getLong();
			Order orders = orderDAO.deleteItem(orderId, itemId);
			LOGGER.info("Order updated");
			return orders;
		} else {
			System.out.println("Please type either 'add' or 'remove'");
		}
		return orderDAO.read(orderId);
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}

}

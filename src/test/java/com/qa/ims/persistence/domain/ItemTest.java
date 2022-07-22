package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemTest {
	

	Item item;
	Long id = (long) 2;
	String itemName ="vest";
	Double price = 10.99;
	
	@Test
	public void constructorOne() {
		item = new Item(id, itemName, price);
	}
	
	@Test
	public void constructorTwo() {
		item = new Item(itemName, price);
	}
	
	@Test
	public void testToString() {
		item = new Item(id, itemName, price);
		assertEquals(("item ID:" + item.getItemId() + " item name:" + item.getItemName() + " item price:" + item.getItemPrice()), item.toString());
	}
	
	@Test
	public void testGetId() {
		item = new Item(id, itemName, price);
		assertEquals(id, item.getItemId());
	}
	
	@Test
	public void testGetItemName() {
		item = new Item(id, itemName, price);
		assertEquals(itemName, item.getItemName());
	}
	
//	@Test
//	public void testGetPrice() {
//		item = new Item(id, itemName, price);
//		assertEquals(price, item.getItemPrice());
//	}
	
	@Test
	public void testSetId() {
		item = new Item(id, itemName, price);
		item.setItemId((long)6);
		assertEquals(6, item.getItemId(), 0.0001);
	}
	
	@Test
	public void testSetItemName() {
		item = new Item(id, itemName, price);
		item.setItemName("tank top");
		assertEquals("tank top", item.getItemName());
		
	}
	
	@Test
	public void testSetPrice() {
		item = new Item(id, itemName, price);
		item.setItemPrice((double) 12.59);
		assertEquals(12.59, item.getItemPrice(), 0.0001);
	}
	
	
	

	@Test
	public void testHashCodeAndEquals() {
		Item a = new Item((long) 9, "toothbrush", 24.99);
		Item b = new Item((long) 4, "floss", 3.99);
		
		Assert.assertFalse(a.equals(b) && b.equals(a));
		Assert.assertFalse(a.hashCode() == b.hashCode());
	}
}

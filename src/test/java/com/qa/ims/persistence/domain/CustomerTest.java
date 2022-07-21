package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {
	
	Customer customer;
	Long id = (long) 2;
	String firstName = "LeBron";
	String surname = "James";
	
	@Test
	public void constructorOne() {
		customer = new Customer(id, firstName,surname);
	}
	
	@Test
	public void constructorTwo() {
		customer = new Customer(firstName,surname);
	}
	
	@Test
	public void testToString() {
		customer = new Customer(id, firstName, surname);
		assertEquals(("id:" + id + " first name:" + firstName + " surname:" + surname), customer.toString());
	}
	
	@Test
	public void testGetId() {
		customer = new Customer(id, firstName, surname);
		assertEquals(id, customer.getId());
	}
	
	@Test
	public void testGetFirstName() {
		customer = new Customer(id, firstName, surname);
		assertEquals(firstName, customer.getFirstName());
	}
	
	@Test
	public void testGetSurname() {
		customer = new Customer(id, firstName, surname);
		assertEquals(surname, customer.getSurname());
	}
	
	@Test
	public void testSetId() {
		customer = new Customer(id, firstName, surname);
		customer.setId((long) 2);
		assertEquals(id, customer.getId());
	}
	
	@Test
	public void testSetFirstName() {
		customer = new Customer(id, firstName, surname);
		customer.setFirstName("Kobe");
		assertEquals("Kobe", customer.getFirstName());
	}
	
	@Test
	public void testSetSurname() {
		customer = new Customer(id, firstName, surname);
		customer.setSurname("Bryant");
		assertEquals("Bryant", customer.getSurname());
	}

	@Test
	public void testHashCodeAndEquals() {
		Customer a = new Customer((long) 9, "Steph", "Curry");
		Customer b = new Customer((long) 4, "DeMarcus", "Cousins");
		
		Assert.assertFalse(a.equals(b) && b.equals(a));
		Assert.assertFalse(a.hashCode() == b.hashCode());
	}

}

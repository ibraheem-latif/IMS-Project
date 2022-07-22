package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

	private Long itemId;
	private String itemName;
	private double itemPrice;

	public Item() {
	}

	public Item(Long itemId, String itemName, double itemPrice) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;

	}

	public Item(String itemName, double itemPrice) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;

	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "item ID:" + itemId + " item name:" + itemName + " item price:" + itemPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, itemName, itemPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(itemId, other.itemId) && Objects.equals(itemName, other.itemName)
				&& Double.doubleToLongBits(itemPrice) == Double.doubleToLongBits(other.itemPrice);
	}

}

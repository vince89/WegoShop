/**
 * 
 */
package com.coffeeshop.entities;

/**
 * @author vincent.p.victor
 *
 */
public class OrderItemDTO {

	/**
	 * 
	 */
	public OrderItemDTO() {
	}
	
	private int orderNumber;
	private String drink;
	private String size;
	private int noOfItems;
	public int getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	private double totalPrice;
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


}

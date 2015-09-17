/**
 * 
 */
package com.coffeeshop.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/**
 * @author vincent.p.victor
 *
 */
@Entity
public class OrderItem {

	/**
	 * 
	 */
	public OrderItem() {
	}

	
	public OrderItem(Drink d, Type t) {
		this.drink = d;
		this.type = t;
	}
 
	@Id
	private int id; 
    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	private int orderNumber;
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="Drink",nullable= false)
	private Drink drink;
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="Type",nullable= false)
	private Type type;
	private int noOfItems;
	private double totalPrice;
//	private Option option;
//	private List<Condiments> condiments;
	
	public int getNoOfItems() {
		return noOfItems;
	}


	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public Drink getDrink() {
		return drink;
	}


	public void setDrink(Drink drink) {
		this.drink = drink;
	}


	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
//	public Option getOption() {
//		return option;
//	}
//	public void setOption(Option option) {
//		this.option = option;
//	}
//	public List<Condiments> getCondiments() {
//		return condiments;
//	}
//	public void setCondiments(List<Condiments> condiments) {
//		this.condiments = condiments;
//	}


}

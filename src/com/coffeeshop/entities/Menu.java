/**
 * 
 */
package com.coffeeshop.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author vincent.p.victor
 *
 */
@Entity
public class Menu {

	@Id
	@GeneratedValue
	private int id;
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="Drink",nullable= false)
	private Drink drink;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="Type",nullable= false)
	private Type type;
	private double price;
	
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}

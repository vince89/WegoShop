package com.coffeeshop.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Tea")
public class Tea  extends Drink {

	public Tea() {
		
	}

	
}

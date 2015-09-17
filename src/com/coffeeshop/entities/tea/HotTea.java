package com.coffeeshop.entities.tea;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.coffeeshop.entities.Tea;
@Entity
@DiscriminatorValue("HotTea")
public class HotTea extends Tea{

	public HotTea() {
		
	}

}

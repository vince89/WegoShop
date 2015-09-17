/**
 * 
 */
package com.coffeeshop.entities.coffee;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.coffeeshop.entities.Coffee;
import com.coffeeshop.entities.Type;

/**
 * @author vincent.p.victor
 *
 */
@Entity
@DiscriminatorValue("Cappuccino")
public class Cappuccino extends Coffee{

	public Cappuccino() {
		
		
	}

	
	
}

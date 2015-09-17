/**
 * 
 */
package com.coffeeshop.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author vincent.p.victor
 *
 */
@Entity
@DiscriminatorValue("Coffee")
public class Coffee extends Drink{

	/**
	 * 
	 */
	public Coffee() {
		
		

		
	}
	

	
	

}

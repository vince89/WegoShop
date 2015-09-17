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
@DiscriminatorValue("Espresso")
public class Espresso extends Coffee{

	public Espresso() {
		
	}

}

/**
 * 
 */
package com.coffeeshop.entities.tea;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.coffeeshop.entities.Tea;
import com.coffeeshop.entities.Type;

/**
 * @author vincent.p.victor
 *
 */
@Entity
@DiscriminatorValue("GreenTea")
public class GreenTea  extends Tea{

	/**
	 * 
	 */
	public GreenTea() {
	}

}

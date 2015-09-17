/**
 * 
 */
package com.coffeeshop.entities.type;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.coffeeshop.entities.Type;

/**
 * @author vincent.p.victor
 *
 */
@Entity
@DiscriminatorValue("Grande")
public class Grande extends Type{

	/**
	 * 
	 */
	public Grande() {
	}

}

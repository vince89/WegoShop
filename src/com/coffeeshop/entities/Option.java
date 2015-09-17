/**
 * 
 */
package com.coffeeshop.entities;

import javax.persistence.Entity;

/**
 * @author vincent.p.victor
 *
 */
@Entity
public class Option {

	/**
	 * 
	 */
	public Option() {
	}
	
	private String optionName;

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

}

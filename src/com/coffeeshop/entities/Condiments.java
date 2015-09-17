/**
 * 
 */
package com.coffeeshop.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author vincent.p.victor
 *
 */
@Entity
public class Condiments {

	/**
	 * 
	 */
	public Condiments() {
	}
	
	public String getCondimentName() {
		return condimentName;
	}

	public void setCondimentName(String condimentName) {
		this.condimentName = condimentName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Id
	private int id;
	private String condimentName;

}

/**
 * 
 */
package com.coffeeshop.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author vincent.p.victor
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
	    name="sizeType",
	    discriminatorType=DiscriminatorType.STRING
	)
public class Type {
	
	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public Type() {
		
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int typeId;

}

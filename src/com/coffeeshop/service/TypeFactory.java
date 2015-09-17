/**
 * 
 */
package com.coffeeshop.service;

import com.coffeeshop.entities.Type;
import com.coffeeshop.entities.type.Grande;
import com.coffeeshop.entities.type.Tall;
import com.coffeeshop.entities.type.Venti;

/**
 * @author vincent.p.victor
 *
 */
public class TypeFactory {

	public  static Type GetType(String type) {


		Type typeObj = null;
		switch(type){

		case "Tall":
			typeObj = new Tall(); 
			break;
		case "Grande":
			typeObj = new Grande();
			break;
		case "Venti":
			typeObj = new Venti();
			break;

		default:


		}

		return typeObj;
	}



}

package com.coffeeshop.service;

import com.coffeeshop.entities.Drink;
import com.coffeeshop.entities.Type;
import com.coffeeshop.entities.coffee.Cappuccino;
import com.coffeeshop.entities.coffee.Espresso;
import com.coffeeshop.entities.coffee.Latte;
import com.coffeeshop.entities.tea.GreenTea;
import com.coffeeshop.entities.tea.HotTea;

public class DrinkFactory {

	public DrinkFactory() {
	}

	public static Drink CreateDrink(String drink) throws Exception
	{
		Drink drinkObj = null;
		
		switch(drink){
		case "GreenTea":
			drinkObj = new GreenTea(); 
			break;
		case "HotTea":
			drinkObj = new HotTea();
			break;
		case "Latte":
			drinkObj = new Latte();
			break;
		case "Espresso":
			drinkObj = new Espresso();
			break;
		case "Cappuccino":
			drinkObj = new Cappuccino();
			break;
		default:
			throw new Exception();

		}

		return drinkObj;
	}
	
	
//	public static Drink getDrinkObj(String drink) throws Exception
//	{
//		Drink drinkObj = null;
//		
//		switch(drink){
//		case "Tea":
//			drinkObj = new GreenTea(); 
//			drinkObj = new HotTea();
//			break;
//		case "Coffee":
//			drinkObj = new Latte();
//			drinkObj = new Espresso();
//			drinkObj = new Cappuccino();
//			break;
//		default:
//			throw new Exception();
//
//		}
//
//		return drinkObj;
//	}

}

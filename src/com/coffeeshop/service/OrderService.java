package com.coffeeshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coffeeshop.dao.CoffeeShopDAO;
import com.coffeeshop.entities.OrderItem;
import com.coffeeshop.entities.OrderItemDTO;
import com.fasterxml.jackson.databind.JsonNode;

public class OrderService {

	@Autowired
	CoffeeShopDAO coffeeshop;

	public void AddMenu()
	{

		coffeeshop.insertOrder();  
	}



	//menu
	public void AddOrders(String drink, String type,int noOfItems) throws Exception
	{
//		Drink d = DrinkFactory.CreateDrink(drink);
//	    Type t = TypeFactory.GetType(type);
		coffeeshop.getPrice(drink,type,noOfItems);

	} 

	
	public void AddOrders(JsonNode node) throws Exception
	{
		String drink="";
		String type="";
		int noOfItems = 0;
		
		if(node.get("drink")!=null)
		{
			drink = node.get("drink").asText("");
		}
		if(node.get("type")!=null)
		{
			type = node.get("type").asText("");
		}
		
		if(node.get("n")!=null)
		{
			noOfItems=Integer.parseInt(node.get("n").asText(""));
		}
		
		System.out.println(drink+type+noOfItems);
		coffeeshop.getPrice(drink,type,noOfItems); 

	} 
	
	
	


	public List<OrderItemDTO> getOrdersByDrink(JsonNode node) throws Exception{
		//Drink d = DrinkFactory.CreateDrink(drink);
		String drink="";
		if(node.get("drink")!=null)
		{
			drink = node.get("drink").asText("");
		}
		
		return coffeeshop.getOrdersByDrink(drink);
	}


	public List<OrderItemDTO> getOrdersByType(JsonNode node){
		String type="";
		if(node.get("type")!=null)
		{
			type = node.get("type").asText("");
		}
		return coffeeshop.getOrdersBySize(type);
	}

	
	public List<OrderItemDTO> getOrders(){
		return coffeeshop.getOrders(); 
	}
	
	

}

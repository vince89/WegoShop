package com.coffeeshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coffeeshop.dao.CoffeeShopDAO;
import com.coffeeshop.entities.Drink;
import com.coffeeshop.entities.OrderItem;
import com.coffeeshop.entities.Type;

public class OrderService {

	@Autowired
	CoffeeShopDAO coffeeshop;
	
	  public void AddOrders()
	  {
	
		  coffeeshop.insertOrder();  
	  }
	  

	
//menu
	  public void AddOrders(String drink, String type) throws Exception
	  {
	      Drink d = DrinkFactory.CreateDrink(drink);
	      Type t = TypeFactory.GetType(type);
	      double p = getPrice(drink,type);
	      OrderItem order = new OrderItem();
	      order.setDrink(d);
	      order.setType(t);
	      order.setTotalPrice(p);
		 // coffeeshop.insertOrder(order); 
	  }
	
	
	  public double getPrice(String drink,String type)
	  {
	    
		  return coffeeshop.getPrice(drink,type);  
	  }
	
	  
	  public List<OrderItem> getOrdersByDrink(String drink){
		  return coffeeshop.getOrdersByDrink(drink);
	  }
	  
	  
	  public List<OrderItem> getOrdersByType(String type){
		  return coffeeshop.getOrdersBySize(type);
	  }
		
		public void AddOrderItem(String drink, String type) throws Exception{
                Drink d = DrinkFactory.CreateDrink(drink);
                Type t = TypeFactory.GetType(type);
                OrderItem o = new OrderItem(d,t);
                //price = db.getPrice(d,t);
               // o.price =price;
		}

}

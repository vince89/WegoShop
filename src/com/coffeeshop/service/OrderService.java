package com.coffeeshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coffeeshop.dao.CoffeeShopDAO;
import com.coffeeshop.entities.OrderItemDTO;
import com.fasterxml.jackson.databind.JsonNode;


public class OrderService {

	@Autowired
	private CoffeeShopDAO coffeeShop;

	public void AddMenu() {

		coffeeShop.insertOrder();
	}

	// menu
	public int AddOrders(String drink, String type, int noOfItems)
			throws Exception {
		// Drink d = DrinkFactory.CreateDrink(drink);
		// Type t = TypeFactory.GetType(type);
		return coffeeShop.insertFinalOrderwithPrice(drink, type, noOfItems);

	}

	//Add Orders
	public int AddOrders(JsonNode node) throws Exception {
		String drink = "";
		String type = "";
		int noOfItems = 0;

		if (node.get("drink") != null) {
			drink = node.get("drink").asText("");
		}
		if (node.get("type") != null) {
			type = node.get("type").asText("");
		}

		if (node.get("n") != null) {
			noOfItems = Integer.parseInt(node.get("n").asText(""));
		}

		return AddOrders(drink, type, noOfItems);

	}

	//Get Orders By Drink
	public List<OrderItemDTO> getOrdersByDrink(JsonNode node) throws Exception {
		// Drink d = DrinkFactory.CreateDrink(drink);
		String drink = "";
		if (node.get("drink") != null) {
			drink = node.get("drink").asText("");
		}

		return coffeeShop.getOrdersByDrink(drink);
	}
	//Get Orders By Type
	public List<OrderItemDTO> getOrdersByType(JsonNode node) {
		String type = "";
		if (node.get("type") != null) {
			type = node.get("type").asText("");
		}
		return coffeeShop.getOrdersBySize(type);
	}

	public List<OrderItemDTO> getOrders() {
		return coffeeShop.getOrders();
	}


}

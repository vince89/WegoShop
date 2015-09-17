package com.coffeeshop.apicontroller;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coffeeshop.entities.OrderItem;
import com.coffeeshop.service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class CoffeeShopController {
	
	@Autowired
	OrderService orderservice;
	
	public CoffeeShopController() throws UnknownHostException {
		//orderservice = new OrderService();
	}
	
	@RequestMapping(headers = {"content-type=application/json"},method=RequestMethod.POST, value="/getDynamicFeeds")
	@ResponseBody
	public void addOrders(@RequestBody String json, HttpServletRequest request) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode feedParams;
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		try {
			feedParams = mapper.readTree(json);
			
			
			//set to the list
			
		    orderservice.AddOrders("GreenTea","Tall");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	
	
	@RequestMapping(method=RequestMethod.GET, value="/getNewOrder")
	@ResponseBody
	public void getNewOrder(HttpServletRequest request) {
		try { 
			orderservice.AddOrders("GreenTea","Tall");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
			//return null;
		}
	}

	
	@RequestMapping(method=RequestMethod.GET, value="/getOrderByDrink")
	@ResponseBody
	public List<OrderItem> getOrdersByDrink(HttpServletRequest request) {
		try { 
			return orderservice.getOrdersByDrink("Tea");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		return null;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getOrderBySize")
	@ResponseBody
	public List<OrderItem> getOrdersBySize(HttpServletRequest request) {
		try { 
			return orderservice.getOrdersByDrink("Tall");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		return null;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getOrder")
	@ResponseBody
	public void getFeeds(HttpServletRequest request) {
		try { 
			 orderservice.AddOrders(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//return null;
		}
	}

}

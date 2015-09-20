package com.coffeeshop.apicontroller;

import java.net.UnknownHostException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coffeeshop.entities.OrderItem;
import com.coffeeshop.entities.OrderItemDTO;
import com.coffeeshop.service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class CoffeeShopController {
	
	@Autowired
	OrderService orderservice;
	
	public CoffeeShopController() throws UnknownHostException {
	}
	

	
	@RequestMapping(headers = {"content-type=application/json"},method=RequestMethod.POST, value="/insertOrder")
	@ResponseBody
	public String getNewOrder(@RequestBody String json, HttpServletRequest request) {
		try { 
			ObjectMapper mapper = new ObjectMapper();
			JsonNode feedParams;
			feedParams = mapper.readTree(json);
 
			if(orderservice.AddOrders(feedParams)==1)
			{
				return "Success";
			}
			return "Fail";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
			return "fail";
		}
	}

	@RequestMapping(headers = {"content-type=application/json"},method=RequestMethod.POST, value="/getOrderByDrink")
	@ResponseBody
	public String getOrdersByDrink(@RequestBody String json,HttpServletRequest request) {
		try { 
			ObjectMapper mapper = new ObjectMapper();
			JsonNode feedParams;
			feedParams = mapper.readTree(json);
			return mapper.writeValueAsString(orderservice.getOrdersByDrink(feedParams));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		return null;
	}
	
	@RequestMapping(headers = {"content-type=application/json"},method=RequestMethod.POST, value="/getOrderByType")
	@ResponseBody
	public String getOrdersBySize(@RequestBody String json,HttpServletRequest request) {
		try { 
			ObjectMapper mapper = new ObjectMapper();
			JsonNode feedParams;
			feedParams = mapper.readTree(json); 
			return mapper.writeValueAsString(orderservice.getOrdersByType(feedParams));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		return null;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/addMenu")
	@ResponseBody
	public void addMenu(HttpServletRequest request) {
		try { 
			 orderservice.AddMenu(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//return null;
		}
	}

	@RequestMapping(method=RequestMethod.GET, value="/getOrders")
	@ResponseBody
	public String getOrders(HttpServletRequest request) {
		try { 
			 ObjectMapper mapper = new ObjectMapper();
			 return mapper.writeValueAsString(orderservice.getOrders()); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
}

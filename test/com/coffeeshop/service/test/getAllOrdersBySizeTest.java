package com.coffeeshop.service.test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.coffeeshop.entities.OrderItemDTO;
import com.coffeeshop.service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/WegoShop-servlet.xml"})
public class getAllOrdersBySizeTest {

	@Autowired
	private OrderService orderService ;
	String drink;
	String type;
	int noOfItems;


	JsonNode actualObj;


	ObjectMapper mapper;

	@Before
	public void setUp() throws Exception {
		mapper = new ObjectMapper();
		actualObj = mapper.readTree("{\"type\":\"Grande\"}");

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetOrdersBySize() {
		List<OrderItemDTO> orders = orderService.getOrdersByType(actualObj);
		assertEquals(3, orders.size());
	}
	
	@Test
	public void testGetOrders() {
		List<OrderItemDTO> orders = orderService.getOrdersByType(actualObj);
		assertEquals("Cappuccino", orders.get(0).getDrink());
	}

	
	@Test
	public void testGetOrdersType() {
		List<OrderItemDTO> orders = orderService.getOrdersByType(actualObj);
		assertEquals("Grande", orders.get(0).getSize());
	}

	
	
}

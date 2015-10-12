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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/WegoShop-servlet.xml"})
public class getAllOrdersTest {
	
	@Autowired
	private OrderService orderService ;


	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetOrders() {
		List<OrderItemDTO> orders = orderService.getOrders();
		assertEquals(21, orders.size());
	}

}

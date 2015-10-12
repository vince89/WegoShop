package com.coffeeshop.dao.test;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.coffeeshop.dao.CoffeeShopDAO;
import com.coffeeshop.entities.OrderItemDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/WegoShop-servlet.xml"})
@WebAppConfiguration
public class CoffeeShopDAOTest {


	@Autowired
	CoffeeShopDAO coffeeShopController;

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertOrder() throws Exception {


		int a = coffeeShopController.insertFinalOrderwithPrice("Latte","Tall",1);
		assertEquals(1,a);
	}


	@Test
	public void testgetOrdersBySize() throws Exception {


		List<OrderItemDTO> a = coffeeShopController.getOrdersBySize("Tall");
		assertEquals(1,a);
	}


	@Test
	public void testgetOrdersByDrink() throws Exception {


		List<OrderItemDTO> a = coffeeShopController.getOrdersByDrink("Latte");
		assertEquals(1,a);
	}


	@Test
	public void testgetOrders() throws Exception {


		List<OrderItemDTO> a = coffeeShopController.getOrders();
		assertEquals(1,a);
	}




}

package com.coffeeshop.apicontroller.test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.nio.charset.Charset;

import org.hamcrest.core.IsNot;
import org.hamcrest.core.IsNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.coffeeshop.apicontroller.CoffeeShopController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/WegoShop-servlet.xml"})
@WebAppConfiguration
public class CoffeeShopControllerTest {

	private MockMvc mockMvc;
	private final String TYPE_REQUEST = "{\"type\" : \"Grande\"}";

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
			MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Autowired
	private WebApplicationContext ctx;

	@Autowired
	private CoffeeShopController coffeeShopController;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.standaloneSetup(coffeeShopController).build();

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testGetOrdersBySize() throws Exception { 


		mockMvc.perform(post("/api/getOrderByType").content("{\"type\" : \"Grande\"}")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())

				.andExpect(jsonPath("$[0].size", is("Grande")));
	}



	@Test
	public void testpostOrders() throws Exception { 


		mockMvc.perform(get("/api/getOrders")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].drink", is("Cappuccino")));
	}
	
	@Test
	public void testpostOrdersSize() throws Exception { 


		mockMvc.perform(get("/api/getOrders")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].drink", notNullValue()));
	}


	@Test
	public void testGetOrdersByDrink() throws Exception { 


		mockMvc.perform(post("/api/getOrderByDrink").content("{\"drink\" : \"Cappuccino\"}")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())

				.andExpect(jsonPath("$[0].drink", is("Cappuccino")));
	}


	@Test
	public void testGetOrdersByDrinkNegative() throws Exception { 


		mockMvc.perform(post("/api/getOrderByDrink").content("{\"drink\" : \"Latte\"}")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("type", nullValue()));	
		
	}


}

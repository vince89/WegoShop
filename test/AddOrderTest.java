import static org.junit.Assert.assertEquals;

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
public class AddOrderTest {
	
	@Autowired
	private OrderService orderService ;
	String drink;
	String type;
	int noOfItems;


	JsonNode actualObj;
	JsonNode actualObj1;
	JsonNode actualObj2;
	ObjectMapper mapper;

	@Before
	public void setUp() throws Exception {
		
		
		drink = "Latte";
		type = "Tall";
		noOfItems = 3;
		
	     mapper = new ObjectMapper();
		 actualObj = mapper.readTree("{\"drink\":\"Cappuccino\",\"type\":\"Grande\",\"n\":\"2\"}");
		 actualObj1 = mapper.readTree("{\"type\":\"Tall\"}");
		 actualObj2 = mapper.readTree("{\"drink\":\"Cappuccino\"}");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertOrder() throws Exception {
		
		int a = orderService.AddOrders(actualObj);
		assertEquals(1,a);

	}

	@Test
	public void testOrders() {
		List<OrderItemDTO> orders = orderService.getOrders();
		assertEquals(21, orders.size());
	}
	
	@Test
	public void testOrdersBySize() {
		List<OrderItemDTO> orders = orderService.getOrdersByType(actualObj1);
		assertEquals(3, orders.size());
	}

	@Test
	public void testOrdersByDrink() throws Exception {
		List<OrderItemDTO> orders = orderService.getOrdersByDrink(actualObj2);
		assertEquals(3, orders.size());
	}

	
}

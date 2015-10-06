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
public class getAllOrdersByDrinkTest {

	@Autowired
	private OrderService orderService ;




	JsonNode actualObj;
	ObjectMapper mapper;

	@Before
	public void setUp() throws Exception {
		mapper = new ObjectMapper();
		actualObj = mapper.readTree("{\"drink\":\"Cappuccino\"}");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetOrdersByDrink() throws Exception {
		List<OrderItemDTO> orders = orderService.getOrdersByDrink(actualObj);
		assertEquals(3, orders.size());
	}

}

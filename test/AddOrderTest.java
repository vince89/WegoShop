import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coffeeshop.apicontroller.CoffeeShopController;


public class AddOrderTest {
	
	CoffeeShopController cdao;
	String drink;
	String type;
	int noOfItems;



	@Before
	public void setUp() throws Exception {
		
		cdao = new CoffeeShopController();
		drink = "Latte";
		type = "Tall";
		noOfItems = 3;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertOrder() throws Exception {
		

	}

	@Test
	public void testGetPrice() {
		fail("Not yet implemented");
	}

	
}

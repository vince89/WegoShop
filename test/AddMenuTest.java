<<<<<<< HEAD
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.coffeeshop.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/WegoShop-servlet.xml"})
public class AddMenuTest {
	@Autowired
	private OrderService orderService ;
=======
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AddMenuTest {
>>>>>>> c98c97c91132436727b53420a2b8103e121255ac

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertOrder() {
<<<<<<< HEAD
		orderService.AddMenu();

=======
		fail("Not yet implemented");
>>>>>>> c98c97c91132436727b53420a2b8103e121255ac
	}

}

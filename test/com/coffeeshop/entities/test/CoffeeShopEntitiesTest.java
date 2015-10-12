package com.coffeeshop.entities.test;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.coffeeshop.apicontroller.CoffeeShopController;
import com.coffeeshop.entities.Drink;
import com.coffeeshop.entities.Type;
import com.coffeeshop.entities.coffee.Cappuccino;
import com.coffeeshop.entities.coffee.Espresso;
import com.coffeeshop.entities.coffee.Latte;
import com.coffeeshop.entities.tea.GreenTea;
import com.coffeeshop.entities.tea.HotTea;
import com.coffeeshop.entities.type.Grande;
import com.coffeeshop.entities.type.Tall;
import com.coffeeshop.entities.type.Venti;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/WegoShop-servlet.xml"})
@WebAppConfiguration
public class CoffeeShopEntitiesTest {





	Drink greenTea = new GreenTea();
	Drink hotTea = new HotTea();
	Drink cappuccino = new Cappuccino();
	Drink latte = new Latte();
	Drink espresso = new Espresso();


	Type tall = new Tall();
	Type grande = new Grande();
	Type venti = new Venti();

	@Before
	public void setUp() throws Exception {


		greenTea.setDrink("GreenTea");
		hotTea.setDrink("HotTea");
		cappuccino.setDrink("Cappuccino");
		latte.setDrink("Latte");
		espresso.setDrink("Espresso");

		tall.setType("Tall");
		grande.setType("Grande");
		venti.setType("Venti");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertOrder() {

		assertEquals("GreenTea",greenTea.getDrink());
		assertEquals("HotTea",hotTea.getDrink());

		assertEquals("Cappuccino",cappuccino.getDrink());
		assertEquals("Latte",latte.getDrink());

		assertEquals("Espresso",espresso.getDrink());

		assertEquals("Tall",tall.getType());

		assertEquals("Grande",grande.getType());
		assertEquals("Venti",venti.getType());



	}

}

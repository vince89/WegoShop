/**
 * 
 */
package com.coffeeshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.coffeeshop.entities.Drink;
import com.coffeeshop.entities.Menu;
import com.coffeeshop.entities.OrderItem;
import com.coffeeshop.entities.OrderItemDTO;
import com.coffeeshop.entities.Type;
import com.coffeeshop.entities.coffee.Cappuccino;
import com.coffeeshop.entities.coffee.Espresso;
import com.coffeeshop.entities.coffee.Latte;
import com.coffeeshop.entities.tea.GreenTea;
import com.coffeeshop.entities.tea.HotTea;
import com.coffeeshop.entities.type.Grande;
import com.coffeeshop.entities.type.Tall;
import com.coffeeshop.entities.type.Venti;

/**
 * @author vincent.p.victor
 * 
 */
public class CoffeeShopDAO {

	/** The session factory. */

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void insertOrder() {

		Session sessiontemp = null;
		// ApplicationContext contextSeperate = new
		// ClassPathXmlApplicationContext(new String[]{"WegoShop-servlet.xml"});
		// SessionFactory sessionFactorytemp = (SessionFactory)
		// contextSeperate.getBean("sessionFactory");
		sessiontemp = sessionFactory.getCurrentSession();
		Drink greenTea = new GreenTea();
		sessiontemp.save(greenTea);
		Drink hotTea = new HotTea();
		sessiontemp.save(hotTea);
		Drink cappuccino = new Cappuccino();
		sessiontemp.save(cappuccino);
		Drink latte = new Latte();
		sessiontemp.save(latte);
		Drink espresso = new Espresso();
		sessiontemp.save(espresso);
		Type tall = new Tall();
		sessiontemp.save(tall);
		Type grande = new Grande();
		sessiontemp.save(grande);
		Type venti = new Venti();
		sessiontemp.save(venti);

		// Menu 1
		Menu menu = new Menu();

		menu.setDrink(greenTea);
		menu.setType(tall);
		menu.setPrice(3.45);

		sessiontemp.save(menu);

		// Menu 2

		menu = new Menu();

		menu.setDrink(greenTea);
		menu.setType(grande);
		menu.setPrice(4.25);

		sessiontemp.save(menu);

		// Menu 3

		menu = new Menu();

		menu.setDrink(greenTea);
		menu.setType(venti);
		menu.setPrice(4.45);

		sessiontemp.save(menu);

		// Menu 4

		menu = new Menu();

		menu.setDrink(hotTea);
		menu.setType(grande);
		menu.setPrice(1.95);

		sessiontemp.save(menu);

		// Menu 5

		menu = new Menu();

		menu.setDrink(cappuccino);
		menu.setType(tall);
		menu.setPrice(3.15);

		sessiontemp.save(menu);

		// Menu 6

		menu = new Menu();

		menu.setDrink(cappuccino);
		menu.setType(grande);
		menu.setPrice(3.75);

		sessiontemp.save(menu);

		// Menu 7

		menu = new Menu();

		menu.setDrink(cappuccino);
		menu.setType(venti);
		menu.setPrice(4.15);

		sessiontemp.save(menu);

		// Menu 7

		menu = new Menu();

		menu.setDrink(latte);
		menu.setType(tall);
		menu.setPrice(3.4);

		sessiontemp.save(menu);

		// Menu 8

		menu = new Menu();

		menu.setDrink(latte);
		menu.setType(grande);
		menu.setPrice(4.45);

		sessiontemp.save(menu);

		// Menu 9
		menu = new Menu();
		menu.setDrink(latte);
		menu.setType(venti);
		menu.setPrice(4.65);
		sessiontemp.save(menu);
		// Menu 10
		menu = new Menu();
		menu.setDrink(espresso);
		menu.setType(venti);
		menu.setPrice(2.35);
		sessiontemp.save(menu);
		// Menu 10
		menu = new Menu();
		menu.setDrink(espresso);
		menu.setType(grande);
		menu.setPrice(2.05);
		sessiontemp.save(menu);

		// Menu 10
		menu = new Menu();
		menu.setDrink(espresso);
		menu.setType(tall);
		menu.setPrice(1.95);

		sessiontemp.save(menu);

	}

	@Transactional
	public int insertFinalOrderwithPrice(String drink, String type,
			int noOfItems) throws Exception {
		Session sessiontemp = null;
		int retValue = 0;
		sessiontemp = sessionFactory.getCurrentSession();
		Criteria c = sessiontemp.createCriteria(Drink.class);
		c.add(Restrictions.eq("class", drink));
		Drink d = (Drink) c.uniqueResult();

		Criteria c1 = sessiontemp.createCriteria(Type.class);
		c1.add(Restrictions.eq("class", type));
		Type t = (Type) c1.uniqueResult();

		Criteria c2 = sessiontemp.createCriteria(Menu.class);
		c2.add(Restrictions.like("drink", d));
		c2.add(Restrictions.like("type", t));
		Menu menu = (Menu) c2.uniqueResult();
		double price = menu.getPrice();
		if (price != 0) {
			OrderItem or = new OrderItem();
			or.setDrink(d);
			or.setType(t);
			or.setNoOfItems(noOfItems);
			or.setTotalPrice(price * noOfItems);
			sessiontemp.save(or);
			retValue = 1;
			return retValue;
		} else {
			throw new Exception();

		}
	}

	@Transactional
	public List<OrderItemDTO> getOrdersBySize(String type) {

		Session sessiontemp = null;
		sessiontemp = sessionFactory.getCurrentSession();
		Criteria c1 = sessiontemp.createCriteria(Type.class);
		c1.add(Restrictions.like("class", type));
		Type t = (Type) c1.uniqueResult();
		Criteria c2 = sessiontemp.createCriteria(OrderItem.class);
		c2.add(Restrictions.like("type", t));
		List<OrderItem> items = (List<OrderItem>) c2.list();
		return mapperObject(items);

	}

	@Transactional
	public List<OrderItemDTO> getOrdersByDrink(String drink) {

		Session sessiontemp = null;
		sessiontemp = sessionFactory.getCurrentSession();
		Criteria c = sessiontemp.createCriteria(Drink.class);
		c.add(Restrictions.like("class", drink));
		Drink d = (Drink) c.uniqueResult();
		System.out.println(d.getClass().toString());
		Criteria c2 = sessiontemp.createCriteria(OrderItem.class);
		c2.add(Restrictions.like("drink", d));
		List<OrderItem> items = (List<OrderItem>) c2.list();
		return mapperObject(items);

	}

	@Transactional
	public List<OrderItemDTO> getOrders() {

		Session sessiontemp = null;
		sessiontemp = sessionFactory.getCurrentSession();
		Criteria c2 = sessiontemp.createCriteria(OrderItem.class);
		List<OrderItem> items = (List<OrderItem>) c2.list();
		System.out.println(items.size());
		return mapperObject(items);

	}

	private List<OrderItemDTO> mapperObject(List<OrderItem> items) {
		List<OrderItemDTO> orderItems = new ArrayList<OrderItemDTO>();
		for (OrderItem order : items) {
			OrderItemDTO orderItem = new OrderItemDTO();
			orderItem.setOrderNumber(order.getId());
			orderItem.setDrink(order.getDrink().getDrink());
			orderItem.setSize(order.getType().getType());
			orderItem.setNoOfItems(order.getNoOfItems());
			orderItem.setTotalPrice(order.getTotalPrice());
			orderItems.add(orderItem);
		}
		return orderItems;
	}

}

/**
 * 
 */
package com.coffeeshop.dao;

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
	public void insertOrder(){
     /*
		Session sessiontemp = null;
		//ApplicationContext contextSeperate = new ClassPathXmlApplicationContext(new String[]{"WegoShop-servlet.xml"});
		//SessionFactory sessionFactorytemp = (SessionFactory) contextSeperate.getBean("sessionFactory");
		sessiontemp = sessionFactory.getCurrentSession();
		Drink drink1 = new GreenTea();
		sessiontemp.save(drink1);
		Drink drink = new HotTea();
		sessiontemp.save(drink);
		drink = new Cappuccino();
		sessiontemp.save(drink);
		drink = new Espresso();
		sessiontemp.save(drink);
		drink = new Latte();
		sessiontemp.save(drink);
	Type type1 = new Tall();
		sessiontemp.save(type1);
		Type type = new Grande();
		sessiontemp.save(type);
		type = new Venti();
		sessiontemp.save(type);

		Menu menu = new Menu();
	
		
		menu.setDrink(drink1);
		menu.setType(type1);
		menu.setPrice(3.15);


		sessiontemp.save(menu); 
        */
	}




	@Transactional
	public double getPrice(Drink d,Type t) {
		
		Session sessiontemp = null;
		sessiontemp = sessionFactory.getCurrentSession();
		System.out.println("1");
		Criteria c2 = sessiontemp.createCriteria(Menu.class);
		System.out.println("1");
		c2.add(Restrictions.like("drink", d));
		System.out.println("1");
		c2.add(Restrictions.like("type",t));
		System.out.println("1");
		Menu menu=(Menu)c2.uniqueResult();
		System.out.println("1");
		return menu.getPrice();
	}




   @Transactional
	public void insertOrder(OrderItem order) {
		Session sessiontemp = null;
		sessiontemp = sessionFactory.getCurrentSession();
		
		sessiontemp.save(order); 
	}



@Transactional
public double getPrice(String drink, String type) {
	Session sessiontemp = null;
	sessiontemp = sessionFactory.getCurrentSession();
	System.out.println("1");
	
	Criteria c = sessiontemp.createCriteria(Drink.class);
	c.add(Restrictions.eq("class", drink));
	Drink d = (Drink) c.uniqueResult();
	System.out.println(d.getClass().toString());
	
	Criteria c1 = sessiontemp.createCriteria(Type.class);
	c1.add(Restrictions.eq("class", type));
	Type t = (Type) c1.uniqueResult();
	System.out.println(t.getClass().toString());
	
	Criteria c2 = sessiontemp.createCriteria(Menu.class);
	System.out.println("1");
	c2.add(Restrictions.like("drink", d));
	System.out.println("1");
	c2.add(Restrictions.like("type",t));
	System.out.println("1");
	Menu menu=(Menu)c2.uniqueResult();
	System.out.println("1");
	double price = menu.getPrice();
	OrderItem or = new OrderItem();
	or.setDrink(d);
	or.setType(t);
	or.setTotalPrice(price);
	sessiontemp.save(or);
	return 0;
}

@Transactional
public List<OrderItem> getOrdersBySize(String type) {
	
	Session sessiontemp = null;
	sessiontemp = sessionFactory.getCurrentSession();
	System.out.println("1");
	
	Criteria c1 = sessiontemp.createCriteria(Type.class);
	c1.add(Restrictions.like("class", type));
	Type t = (Type) c1.uniqueResult();
	System.out.println(t.getClass().toString());
	
	Criteria c2 = sessiontemp.createCriteria(Menu.class); 
	System.out.println("1");
	c2.add(Restrictions.like("type", t));
	
	List<OrderItem> items = (List<OrderItem>) c2.list();
	return items;
	
}


@Transactional
public List<OrderItem> getOrdersByDrink(String drink) {
	
	Session sessiontemp = null;
	sessiontemp = sessionFactory.getCurrentSession();
	System.out.println("1");
	
	Criteria c = sessiontemp.createCriteria(Drink.class);
	c.add(Restrictions.like("class", drink));
	Drink d = (Drink) c.uniqueResult();
	System.out.println(d.getClass().toString());
	
	Criteria c2 = sessiontemp.createCriteria(Menu.class);
	System.out.println("1");
	c2.add(Restrictions.like("drink", d));
	
	List<OrderItem> items = (List<OrderItem>) c2.list();
	return items;
	
}


}

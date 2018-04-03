package com.org.hibernate.sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.org.sample.hbt.Address;
import com.org.sample.hbt.UserDetails;
import com.org.sample.hbt.UserDetails1;
import com.org.sample.hbt.UserDetails2;



public class HibernateTest {
	
	static SessionFactory sessionFactory;
	static Session session;
	
	public static void main(String args[]) {
		
		/*Address add1=new Address();
		add1.setCity("Cit1");
		add1.setState("State1");
		add1.setStreet("Street1");
		add1.setPincode("Pincode1");
		
		Address add2=new Address();
		add2.setCity("Cit2");
		add2.setState("State2");
		add2.setStreet("Street2");
		add2.setPincode("Pincode2");
		
		UserDetails userDetails=new UserDetails();
		userDetails.setHomeaddress(add1);
		userDetails.setOfficeAddress(add2);
		userDetails.setUserName("First User");
		userDetails.setJoinedDate(new Date());
		userDetails.setDescription("description");
		
		UserDetails user=new UserDetails();
		user.setUserName("Second User");
		user.setHomeaddress(add1);
		user.setOfficeAddress(add2);
		user.setJoinedDate(new Date());
		user.setDescription("description");*/
		
		sessionFactory=getSessionFactory();
		
		/*session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.save(user);
		session.getTransaction().commit();
		session.close();*/
		
		//saving collection to Database
		/*UserDetails1 us1=new UserDetails1();
		us1.setUserName("User1");
		Collection<Address> ad=new ArrayList<Address>();
		ad.add(add1);
		ad.add(add2);
		us1.setListOfAddress(ad);*/
		/*session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(us1);
		session.getTransaction().commit();
		session.close();*/
		
		/*userDetails=null;

		session=sessionFactory.openSession();
		session.beginTransaction();
		userDetails=(UserDetails)session.get(UserDetails.class, 3);
		System.out.println("Username="+ userDetails.getUserName());
		session.close();*/
		
		/*us1=null;
		session=sessionFactory.openSession();
		session.beginTransaction();
		us1=(UserDetails1)session.get(UserDetails1.class, 6);
		System.out.println(us1.getListOfAddress().size());
		session.close();
*/
		UserDetails2 us2=new UserDetails2();
		us2.setUserName("First User");

		
		
	}
	
	public static SessionFactory getSessionFactory() {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");        	
		StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
		sb.applySettings(cfg.getProperties());
		StandardServiceRegistry standardServiceRegistry = sb.build();
		return cfg.buildSessionFactory(standardServiceRegistry);
	}

}

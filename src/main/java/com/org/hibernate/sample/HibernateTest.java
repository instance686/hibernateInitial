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

import com.org.sample.hbt.UserDetails2;
import com.org.sample.hbt.Vehicle;



public class HibernateTest {
	
	static SessionFactory sessionFactory;
	static Session session;
	
	public static void main(String args[]) {
				
	
		UserDetails2 us2=new UserDetails2();
		us2.setUserName("First User");
		
		Vehicle vh=new Vehicle();
		vh.setVehicleName("Car");
		
		us2.setVehicle(vh);
		
		sessionFactory=getSessionFactory();

		
		session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(us2);
		session.save(vh);
		session.getTransaction().commit();
		session.close();

		
		
	}
	
	public static SessionFactory getSessionFactory() {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");        	
		StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
		sb.applySettings(cfg.getProperties());
		StandardServiceRegistry standardServiceRegistry = sb.build();
		return cfg.buildSessionFactory(standardServiceRegistry);
	}

}

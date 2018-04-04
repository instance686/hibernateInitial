package com.org.hibernate.sample;

  

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.org.sample.hbt.FourWheeler;
import com.org.sample.hbt.TwoWheeler;
import com.org.sample.hbt.UserDetails;
import com.org.sample.hbt.UserDetails2;
import com.org.sample.hbt.Vehicle;



public class HibernateTest {
	
	static SessionFactory sessionFactory;
	static Session session;
	
	public static void main(String args[]) {
					
		sessionFactory=getSessionFactory();
		session=sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user=(UserDetails)session.get(UserDetails.class, 1);
		session.getTransaction().commit();
		session.close();
			
		session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
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

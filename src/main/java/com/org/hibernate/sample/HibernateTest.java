package com.org.hibernate.sample;

  

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.org.sample.hbt.UserDetails;



public class HibernateTest {
	
	static SessionFactory sessionFactory;
	static Session session;
	
	public static void main(String args[]) {
					
		sessionFactory=getSessionFactory();
		session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from USER_DETAILS where userId > ?");
		query.setInteger(0, 5);
		List<UserDetails> users=(List<UserDetails>)query.list();
		session.getTransaction().commit();
		session.close();
		System.out.println(users.size());
		for(UserDetails us:users) {System.out.println(us.getUserName());}
		
	}
	
	
	public static SessionFactory getSessionFactory() {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");        	
		StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
		sb.applySettings(cfg.getProperties());
		StandardServiceRegistry standardServiceRegistry = sb.build();
		return cfg.buildSessionFactory(standardServiceRegistry);
	}

}

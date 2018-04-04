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
		Query query=session.createQuery("select userName from USER_DETAILS where userId > 5");
		query.setFirstResult(5);//skips first 5 records from above select statement
		query.setMaxResults(4);//pulls only 4 records
		//List<UserDetails> users=(List<UserDetails>)query.list();
		List<String> users=(List<String>)query.list();
		session.getTransaction().commit();
		session.close();
		
		for(String us:users) {
			System.out.println(us);
		}
		
	}
	
	
	public static SessionFactory getSessionFactory() {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");        	
		StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
		sb.applySettings(cfg.getProperties());
		StandardServiceRegistry standardServiceRegistry = sb.build();
		return cfg.buildSessionFactory(standardServiceRegistry);
	}

}

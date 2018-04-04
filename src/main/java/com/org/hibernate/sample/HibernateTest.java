package com.org.hibernate.sample;

  

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.org.sample.hbt.UserDetails;



public class HibernateTest {
	
	static SessionFactory sessionFactory;
	static Session session;
	
	public static void main(String args[]) {
					
		sessionFactory=getSessionFactory();
		session=sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails exampleUser=new UserDetails();
		//exampleUser.setUserId(7);-primary key and null properties are not considered
		exampleUser.setUserName("USER 1%");
		
		Example example=Example.create(exampleUser).enableLike(); 
		
		Criteria criteria=session.createCriteria(UserDetails.class)
							.add(example);
		List<UserDetails> users=(List<UserDetails>)criteria.list();
		session.getTransaction().commit();
		session.close();
		System.out.println(users.size());
		for(UserDetails us:users) {System.out.println(us.getUserId());}
		
	}
	
	
	public static SessionFactory getSessionFactory() {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");        	
		StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
		sb.applySettings(cfg.getProperties());
		StandardServiceRegistry standardServiceRegistry = sb.build();
		return cfg.buildSessionFactory(standardServiceRegistry);
	}

}

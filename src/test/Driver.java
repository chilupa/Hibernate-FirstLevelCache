package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dto.UserDetails;

public class Driver {

	
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		// First session
		session = sessionFactory.openSession();
		session.beginTransaction();
	
		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		// Second session
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
	
		user = (UserDetails) session2.get(UserDetails.class, 1);
		
		session2.getTransaction().commit();
		session2.close();

	}

}

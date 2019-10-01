package com.zensar.hibernate.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Product;

public class HQLmain {

	public static void main(String[] args) {
		
		// HQL - Hibernate Query Language (Object Oriented Query Language)
		Configuration c = new Configuration().configure();			// .configure() reads hibernate.cfg.xml and returns an object of the same class.
		SessionFactory f = c.buildSessionFactory();					// heavyweight and singleton SessionFactory.
		Session s = f.openSession();								// represents database connection and lightweight.
		Transaction t = s.beginTransaction();
		
		// Query q = s.createQuery("from Product");					// This is a JPA query. (Package: javax.persistence.Query)
		// Query q = s.createQuery("from Product p where p.price > 15000 and p.price < 40000");
		// Query q = s.createQuery("from Product p where p.price between 15000 and 40000");
		// Query q = s.createQuery("from Product p where p.brand LIKE 'S%'");
		// Query q = s.createQuery("from Product p where p.name='LED TV'");
		// List<Product> products = q.getResultList();
//		for (Product currProd: products)
//		{
//			System.out.println(currProd);
//		}
//		Query q = s.createQuery("select p.name, p.price from Product p");
//		List<Object[]> objects = q.getResultList();					// List<Object[] is called list of array of objects
//		for (Object[] object: objects)
//		{
//			for (Object currProd: object)
//			{
//				System.out.print(currProd + "\t");
//			}
//			System.out.println();
//		}
		
//		Query q = s.createQuery("select p.name, p.price, p.brand from Product p");
//		List<Object[]> objects = q.getResultList();					// List<Object[] is called list of array of objects
//		for (Object[] object: objects)
//		{
//			for (Object currProd: object)
//			{
//				System.out.print(currProd + "\t");
//			}
//			System.out.println();
//		}
		
		Query q1 = s.createQuery("select max(p.price) from Product p");
		Float maxPrice = (Float) q1.getSingleResult();
		System.out.println("Maximum Price: " + maxPrice);
		
		Query q2 = s.createQuery("select min(p.price) from Product p");
		Float minPrice = (Float) q2.getSingleResult();
		System.out.println("Minimum Price: " + minPrice);
		
		Query q3 = s.createQuery("select AVG(p.price) from Product p");
		Double avgPrice = (Double) q3.getSingleResult();
		System.out.println("Average Price: " + avgPrice);
		
		Query q4 = s.createQuery("select COUNT(p.price) from Product p");
		Long ctPrice = (Long) q4.getSingleResult();
		System.out.println("Count of Price: " + ctPrice);
		
//		@SuppressWarnings("deprecation")
//		Criteria cr = s.createCriteria(Product.class);
//		List<Product> products = cr.list();
//		for (Product currProduct: products)
//		{
//			System.out.println(currProduct);
//		}

		t.commit();
		s.close();

	}

}

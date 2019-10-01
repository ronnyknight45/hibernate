package com.zensar.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Product;

public class DbOperations {
	
	public static void main(String[] args) {
		
		Configuration c = new Configuration().configure();			// .configure() reads hibernate.cfg.xml and returns an object of the same class.
		SessionFactory f = c.buildSessionFactory();					// heavyweight and singleton SessionFactory.
		Session s = f.openSession();								// represents database connection and lightweight.
		Transaction t = s.beginTransaction();
		
		// Product product1 = new Product(1009, "Redmi 6A newID", "Redmi", 6499);
		// s.save(product1);
		
		// Get record according to primary key
		// Product p = s.load(Product.class, 1006);
		
//		Product p = s.get(Product.class, 1006);
//		
//		try
//		{
//			if (p.equals(null))
//			{
//				throw new NullPointerException();
//			}
//			else
//			{
//				System.out.println(p);
//			}
//		}
//		catch (NullPointerException exc)
//		{
//			System.out.println("Whoops! That object you asked for does not exist!");
//		}
		
		// Update a record
//		Product p = s.get(Product.class, 1006);
//		try
//		{
//			if (p.equals(null))
//			{
//				throw new NullPointerException();
//			}
//			else
//			{
//				p.setPrice((float) 35.63);
//				s.update(p);
//				System.out.println("Price updated successfully.");
//			}
//		}
//		catch (NullPointerException exc)
//		{
//			System.out.println("Whoops! That object you asked for does not exist!");
//		}
		
//		Product p = s.get(Product.class, 1006);
//		try
//		{
//			if (p.equals(null))
//			{
//				throw new NullPointerException();
//			}
//			else
//			{
//				System.out.println("Previous price: " + p.getPrice());
//				p.setPrice((float) (p.getPrice() * 1.5));
//				s.update(p);
//				System.out.println("Price updated successfully by 50%.");
//				System.out.println("Current price: " + p.getPrice());
//			}
//		}
//		catch (NullPointerException exc)
//		{
//			System.out.println("Whoops! That object you asked for does not exist!");
//		}
		
		// Delete Record
		Product p = s.get(Product.class, 1006);
		try
		{
			if (p.equals(null))
			{
				throw new NullPointerException();
			}
			else
			{
				s.delete(p);
				System.out.println("Product deleted successfully!");
			}
		}
		catch (NullPointerException exc)
		{
			System.out.println("Whoops! That object you asked for does not exist!");
		}
		
		t.commit();
		s.close();
	}

}

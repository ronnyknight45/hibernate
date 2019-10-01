package com.zensar.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Country;
import com.zensar.entities.Flag;

public class OneToOneMappingMain {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		SessionFactory sf = configuration.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Country country = new Country();
		country.setName("India");
		country.setPopulation(73541265l);		// 'l' indicates long.
		country.setLanguage("Hindi");
		
		Flag flag = new Flag();
		flag.setFlagName("Tiranga");
		flag.setDescription("Tricolor flag");
		
		country.setFlag(flag);
		flag.setCountry(country);
		
		s.save(flag);
		s.save(country);
		t.commit();
		s.close();
		
		System.exit(0);

	}

}

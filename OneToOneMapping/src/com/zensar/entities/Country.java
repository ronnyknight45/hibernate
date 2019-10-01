package com.zensar.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author Gourab Sarkar
 * @creation_date 27 Sep 2019 14:56
 * @modification_date 27 Sep 2019 14:56
 * @version 1.0
 * @description This is a class that represents One-to-One Mapping
 */

@Entity
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int countryId;
	private String name;
	private String language;
	private long population;
	// @OneToOne(mappedBy = "country")			// Using mapped by makes this a parent class
	@OneToOne
	@JoinColumn(name = "flagID")
	private Flag flag;							// This is not a component mapping.
	
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	public Flag getFlag() {
		return flag;
	}
	public void setFlag(Flag flag) {
		this.flag = flag;
	}
	
}

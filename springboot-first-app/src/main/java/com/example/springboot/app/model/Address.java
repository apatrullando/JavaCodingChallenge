package com.example.springboot.app.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column(name = "street", table = "address")
	private String street;
	
	@Column(name = "city", table = "address")
	private String city;
	
	@Column(name = "state", table = "address")
	private String state;
	
	@Column(name = "zip", table = "address")
	private String zip;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
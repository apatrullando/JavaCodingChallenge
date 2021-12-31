package com.example.springboot.app.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Phone {
	
	@Column(name = "contact", table = "phone")
	private String number;
	
	@Column(name = "type", table = "phone")
	private String type;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}

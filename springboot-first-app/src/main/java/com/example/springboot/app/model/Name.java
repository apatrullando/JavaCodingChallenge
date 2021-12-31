package com.example.springboot.app.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Name {
	
	@Column(name = "first", table = "name")
	private String first;
	
	@Column(name = "middle", table = "name")
	private String middle;
	
	@Column(name = "last", table = "name")
	private String last;

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}
}

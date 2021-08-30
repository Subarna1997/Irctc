package com.hcl.Irctc.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class Passenger {
	
	
	@Column(length=30)
	private String name;
	
	@Column(length=10)
	private int age;
	
	@Column(length=50)
	private String adhaardetails;
	
	@Column(length=50)
	private String address;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	

	public String getAdhaardetails() {
		return adhaardetails;
	}

	public void setAdhaardetails(String adhaardetails) {
		this.adhaardetails = adhaardetails;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}

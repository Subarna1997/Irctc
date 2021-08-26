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
	private String age;
	
	@Column(length=16)
	private int adhaardetails;
	
	@Column(length=50)
	private String address;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int getAdhaardetails() {
		return adhaardetails;
	}

	public void setAdhaardetails(int adhaardetails) {
		this.adhaardetails = adhaardetails;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}

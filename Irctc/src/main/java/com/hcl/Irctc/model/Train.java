package com.hcl.Irctc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Train {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int trainid;
	
	@Column(length=50)
	private String trainname;
	
	@Column(length=10)
	private int trainno;
	
	@Column(length=20)
	private String source;

	@Column(length =20)
	private String destination;
	
	@Column(length=10)
	private double price;
	
	@Column(length=10)
	private int seats;
	
	@Column(length=20)
	@Enumerated(EnumType.STRING)
	@ElementCollection
	private List<Days> day;
	

	
	
	

	public List<Days> getDay() {
		return day;
	}

	public void setDay(List<Days> day) {
		this.day = day;
	}

	public int getTrainid() {
		return trainid;
	}

	public void setTrainid(int trainid) {
		this.trainid = trainid;
	}

	public String getTrainname() {
		return trainname;
	}

	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}

	public int getTrainno() {
		return trainno;
	}

	public void setTrainno(int trainno) {
		this.trainno = trainno;
	}

	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	
	
	
}

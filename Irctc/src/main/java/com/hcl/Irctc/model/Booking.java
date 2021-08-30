package com.hcl.Irctc.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Booking {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingid;
	
	 @OneToOne(targetEntity = User.class)
	 @JoinColumn(name="userId")
	 private User user;
	 
	 @OneToOne(targetEntity = Train.class)
	 @JoinColumn(name="trainid")
	 private Train train;
	
	 private double total_price;
	 
		private Date date;
		
	    @Embedded
	    @ElementCollection
		private List<Passenger> passengers;
	
	
	 
	 
	 public Booking(Train train2, User user2) {
		// TODO Auto-generated constructor stub
		 super();
	}

	

	public Booking() {
		// TODO Auto-generated constructor stub
	}



	public double getTotal_price() {
		return total_price;
	}



	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public List<Passenger> getPassengers() {
		return passengers;
	}



	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}



	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

 

}

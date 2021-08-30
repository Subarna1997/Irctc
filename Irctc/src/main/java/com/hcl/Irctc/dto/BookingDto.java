package com.hcl.Irctc.dto;

import java.util.List;

import com.hcl.Irctc.model.Passenger;

public class BookingDto {
	
	private int trainid;
	private int userid;
	
	private List<Passenger> passengers;
	
	
	
	
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	public int getTrainid() {
		return trainid;
	}
	public void setTrainid(int trainid) {
		this.trainid = trainid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	

}

package com.hcl.Irctc.service;

import org.springframework.stereotype.Service;

import com.hcl.Irctc.model.Booking;
import com.hcl.Irctc.model.Train;
import com.hcl.Irctc.model.User;

@Service
public interface BookingService {
	
	public void addToBooking( Train train, User user);
	public Booking getBookingById(Integer bookingid);

}

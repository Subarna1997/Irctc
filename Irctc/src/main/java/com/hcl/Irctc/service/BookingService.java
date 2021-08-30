package com.hcl.Irctc.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.Irctc.exception.BookingNotDoneException;
import com.hcl.Irctc.exception.TicketNotFoundException;
import com.hcl.Irctc.model.Booking;
import com.hcl.Irctc.model.Passenger;
import com.hcl.Irctc.model.Train;
import com.hcl.Irctc.model.User;

@Service
public interface BookingService {
	
	
	
	
	public List<Booking> getBooking(int userId) throws TicketNotFoundException;
	
	//public Booking getBookingById(Integer bookingid);

	public String addToBooking(int trainid , int userId, List<Passenger> passengers)  throws BookingNotDoneException;

}

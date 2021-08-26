package com.hcl.Irctc.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.Irctc.dao.BookingDao;

import com.hcl.Irctc.model.Booking;
import com.hcl.Irctc.model.Train;
import com.hcl.Irctc.model.User;


@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	BookingDao bookingdao;
	
	public void addToBooking( Train train, User user){
        Booking booking  = new Booking(train, user);
        bookingdao.save(booking);
    }
	
	 public Booking getBookingById(Integer bookingid) {
	        Optional<Booking> optionalBooking = bookingdao.findById(bookingid);
	        if (!optionalBooking.isPresent())
	        {
	            return null;	
	        }
	        return optionalBooking.get();
	    }

}

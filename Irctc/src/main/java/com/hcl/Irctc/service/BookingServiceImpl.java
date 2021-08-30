package com.hcl.Irctc.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.Irctc.GlobalLogger;
import com.hcl.Irctc.controller.BookingContoller;
import com.hcl.Irctc.dao.BookingDao;
import com.hcl.Irctc.dao.TrainDao;
import com.hcl.Irctc.dao.UserDao;
import com.hcl.Irctc.exception.BookingNotDoneException;
import com.hcl.Irctc.exception.TicketNotFoundException;
import com.hcl.Irctc.model.Booking;
import com.hcl.Irctc.model.Passenger;
import com.hcl.Irctc.model.Train;
import com.hcl.Irctc.model.User;




@Service
public class BookingServiceImpl implements BookingService{
	
	private Logger logger = GlobalLogger.getLogger(BookingServiceImpl.class);
	
	@Autowired
	BookingDao bookingdao;
	
	@Autowired
	TrainDao traindao;
	
	@Autowired
	UserDao userdao;
	
	
	public String addToBooking( int trainid, int userId, List<Passenger> passengers) throws BookingNotDoneException{

	
     Train train1 = traindao.findByTrainid(trainid);
	  User user1 = userdao.findByUserId(userId);
      
		if(train1 != null && user1 != null) {
		 
		logger.info("Set the Booking values");
		Booking booking  = new Booking();
        booking.setUser(user1);
        booking.setTrain(train1);
        booking.setDate(new Date());
        booking.setPassengers(passengers);
		booking.setTotal_price(passengers.size() * train1.getPrice());
        
		logger.info("Saved To Database");
        bookingdao.save(booking);
        return "Ticket Booked";
        
    } throw new BookingNotDoneException("Booking is not Done");
	
		
	}
	
	


	
	 
	 @Override
		public List<Booking> getBooking(int userId) throws TicketNotFoundException {
	      
			Optional<User> user = userdao.findById(userId);
			if(!user.isPresent()) {
			
				throw new TicketNotFoundException("Booking Not Found");
			}
			List<Booking> bookings = bookingdao.getBooking(userId);
			{
				if(!bookings.isEmpty()) {
					return bookings;
				}
				throw new TicketNotFoundException("Booking Not Found");
			}

		} 
	 }


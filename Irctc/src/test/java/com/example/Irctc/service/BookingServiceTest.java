package com.example.Irctc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.hcl.Irctc.controller.BookingContoller;
import com.hcl.Irctc.dao.BookingDao;
import com.hcl.Irctc.dao.TrainDao;
import com.hcl.Irctc.dao.UserDao;
import com.hcl.Irctc.dto.Check;
import com.hcl.Irctc.exception.BookingNotDoneException;
import com.hcl.Irctc.exception.TicketNotFoundException;
import com.hcl.Irctc.model.Booking;
import com.hcl.Irctc.model.Days;
import com.hcl.Irctc.model.Passenger;
import com.hcl.Irctc.model.Train;
import com.hcl.Irctc.model.User;
import com.hcl.Irctc.service.BookingService;
import com.hcl.Irctc.service.BookingServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {
	
	@Mock
	BookingDao bookingdao;
	
	@Mock
	TrainDao traindao;
	
	@Mock
	UserDao userdao;
	
	
	@InjectMocks
	BookingServiceImpl bookingservice;
	
	static Passenger passenger;
	static User user;
	static Train train;
	static Booking booking;
	static List<Days> days;
	static Days days1;
	
	 static List<Passenger> passengers = new ArrayList<Passenger>();
	 static List<Booking> bookings = new ArrayList<Booking>();
	
	 static List<Booking> options;
	 
	@BeforeAll
	public static void setUp() {
	
		user = new User();
		user.setEmail("s@gmail.com");
		user.setPhoneNumber("123467");;
		user.setPassword("sadak");
		user.setUserId( 1);
		user.setUserName("Subarna");
		
		
		//options = optional.of(Booking);
		
		train = new Train();
		train.setDays(days);
		train.setDestination("DEL");
		train.setSource("CSMT");
		train.setPrice(123);
		train.setSeats(12);
		train.setTrainid(1);
		train.setTrainname("Rajdhani");
		train.setTrainno(12356);
		
		passenger = new Passenger();
		passenger.setAddress("sssss");
		passenger.setAdhaardetails("1234567890");
		passenger.setAge(45);
		passenger.setName("Subarna");
		
		passengers.add(passenger);
		
		booking = new Booking();
		booking.setBookingid(1);
		booking.setDate(new Date());
		booking.setTotal_price(123.00);
		booking.setTrain(train);
		booking.setUser(user);
		booking.setPassengers(passengers);
		
		bookings.add(booking);
		
	}
	
	
	@Test
	@DisplayName("Add To Booking")
	public void addbooking() throws BookingNotDoneException {
		//when
		when(bookingdao.save(booking)).thenReturn(booking);
		
		//then
		String booking1 = bookingservice.addToBooking(1, 1, passengers);
		
		//outcome
		assertEquals("Ticket Booked", booking1);
	}
	
	
	
	
	
	@Test
	@DisplayName("Get All Bookings : Positive")
	public void getall1() throws TicketNotFoundException {
		
		//given
		
		when(bookingdao.getBooking(1)).thenReturn(options);
		
		//when or, event
		List<Booking> bookings = bookingservice.getBooking(1);
		//then
		
		assertEquals(bookings,options);
	}
	
	@Test
	@DisplayName("Get All Bookings : Negative")
	public void getall2(){
	//given or context
			when(bookingdao.getBooking(1)).thenThrow(NullPointerException.class);
			
			
			//then or outcome
			assertThrows(NullPointerException.class, ()->bookingservice.getBooking(1));

}
	
	
}

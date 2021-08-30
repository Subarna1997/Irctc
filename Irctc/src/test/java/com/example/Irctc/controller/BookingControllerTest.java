package com.example.Irctc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.Irctc.controller.BookingContoller;
import com.hcl.Irctc.dao.TrainDao;
import com.hcl.Irctc.dto.BookingDto;
import com.hcl.Irctc.exception.BookingNotDoneException;
import com.hcl.Irctc.exception.TicketNotFoundException;
import com.hcl.Irctc.model.Booking;
import com.hcl.Irctc.model.Days;
import com.hcl.Irctc.model.Passenger;
import com.hcl.Irctc.model.Train;
import com.hcl.Irctc.model.User;
import com.hcl.Irctc.service.BookingService;
import com.hcl.Irctc.service.TrainService;
import com.hcl.Irctc.service.UserService;

@ExtendWith(MockitoExtension.class)
public class BookingControllerTest {
	
	@Mock
	TrainService trainservice;
	
	@Mock
	UserService userservice;
	
	@Mock
	BookingService bookingservice;
	
	
	@InjectMocks
	BookingContoller bookingcontroller;
	
	static Passenger passenger;
	static User user;
	static Train train;
	static Booking booking;
	static TrainDao traindao;
	static List<Days> days;
	static BookingDto bookingdto;
	 
	 static List<Passenger> passengers = new ArrayList<Passenger>();
	 static List<Booking> bookings = new ArrayList<Booking>();
	
	@BeforeAll
	public static void setUp() {
	
		user = new User();
		user.setEmail("s@gmail.com");
		user.setPhoneNumber("345678");;
		user.setPassword("sadak");
		user.setUserId( 1);
		user.setUserName("Subarna");
		
		
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
		
		bookingdto = new BookingDto();
		bookingdto.setPassengers(passengers);
		bookingdto.setTrainid(1);
		bookingdto.setUserid(1);
	}
	
	@Test
	@DisplayName("Train Insert: Positive Scenario")
	public void trainadd1() {
		//given or context
		when(trainservice.InsertTrain(train)).thenReturn(train);
		
		//when or event
		ResponseEntity<?> result = bookingcontroller.saveTrain(train);
		
		//then or outcome
		assertEquals(train, result.getBody());
	}
	
	@Test
	@DisplayName("Train Insert: Negative Scenario")
	public void trainadd2() {
		//given or context
		when(trainservice.InsertTrain(train)).thenThrow(NullPointerException.class);
		
		
		//then or outcome
		assertThrows(NullPointerException.class, ()->bookingcontroller.saveTrain(train));
	}
	
	
//	@Test
//	@DisplayName("Ticket Booking : Positive Scenerio")
//	public void booking1() throws BookingNotDoneException {
//		
//		//given
//		when(bookingservice.addToBooking(2, 4, passengers)).thenReturn("Ticket Booked");
//		
//		//then
//		ResponseEntity<?> result = bookingcontroller.bookingTicket(bookingdto);
//		
//		//outcome
//       	
//		assertEquals(HttpStatus.ACCEPTED, result.getStatusCode());
//	}
//	

	@Test
	@DisplayName("Ticket Booking: Negative")
	public void booking2() throws BookingNotDoneException  {
		
		//given
		when(bookingservice.addToBooking(2, 4, passengers)).thenReturn("Ticket Booked");
		

		//outcome
		assertThrows(BookingNotDoneException.class, ()->bookingcontroller.bookingTicket(bookingdto));
	
	}
	
	
	
	@Test
	@DisplayName(" Booked History")
	public void history() throws TicketNotFoundException {
		
		//given
		
		when(bookingservice.getBooking(1)).thenReturn(bookings);
		
		//then
		ResponseEntity<?> bookings = bookingcontroller.getBooking(1);
		
		//outcome
		
		assertEquals(HttpStatus.ACCEPTED, bookings.getStatusCode());
	}
	
	
}

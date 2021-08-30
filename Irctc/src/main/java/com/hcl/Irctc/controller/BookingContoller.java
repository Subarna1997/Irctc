package com.hcl.Irctc.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.Irctc.GlobalLogger;
import com.hcl.Irctc.dto.BookingDto;
import com.hcl.Irctc.dto.Check;
import com.hcl.Irctc.exception.BookingNotDoneException;
import com.hcl.Irctc.exception.TicketNotFoundException;
import com.hcl.Irctc.exception.TrainNotFoundException;
import com.hcl.Irctc.model.Booking;
import com.hcl.Irctc.model.Passenger;
import com.hcl.Irctc.model.Train;
import com.hcl.Irctc.model.User;
import com.hcl.Irctc.service.BookingService;
import com.hcl.Irctc.service.TrainService;
import com.hcl.Irctc.service.UserService;


import io.swagger.annotations.ApiOperation;


@ApiOperation(value = "/api/v1/trains" , tags="Booking Controller" )
@RestController
public class BookingContoller {
	
	
	private Logger logger = GlobalLogger.getLogger(BookingContoller.class);
	
	@Autowired
	TrainService trainservice;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	BookingService bookingservice;
	
	@ApiOperation(value="Input Train Details", response=Train.class)
	@PostMapping("/addtrain")
	public ResponseEntity<?> saveTrain(@RequestBody Train train) throws NullPointerException {
        if(train != null) {
        logger.info("Train Details Are Saved In Database");
		Train train1 = trainservice.InsertTrain(train);
        return new ResponseEntity<Train>(train1,  HttpStatus.CREATED);
    
	}
	  throw new NullPointerException("Train Not Listed");
	}

	@ApiOperation(value="Search Trains", response=Train.class)
	@PostMapping("/trains")
	public ResponseEntity<List<Train>> getTrainList(@Valid @RequestBody Check check) throws ParseException, TrainNotFoundException {
	
		logger.info("According To Search, Trains are found");
		List<Train>trainList=trainservice.SearchTrains(check);
	
	return new ResponseEntity<List<Train>>(trainList,HttpStatus.OK);
	}
	
	
	@ApiOperation(value="Book Tickets", response=Booking.class)
	@PostMapping("/tickets")
	public ResponseEntity<?> bookingTicket(@RequestBody BookingDto bookingdto) throws BookingNotDoneException {
		if(bookingdto.getUserid() != 0) {
		logger.info("Booking Details are saved into Database");
		return new ResponseEntity<String>(bookingservice.addToBooking(bookingdto.getTrainid(), bookingdto.getUserid(),bookingdto.getPassengers()), HttpStatus.ACCEPTED);
	}
		throw new BookingNotDoneException("Booking Is Not Done");
	}
	
	
	

	@ApiOperation(value="SHOW BOOKING HISTORY", response=Booking.class)
	@GetMapping
	public ResponseEntity<?> getBooking(@RequestParam int userId) throws TicketNotFoundException {
		logger.info("Booking History Is Shown");
		  return new ResponseEntity<List<Booking>>(bookingservice.getBooking(userId), HttpStatus.ACCEPTED);
	}

	

}

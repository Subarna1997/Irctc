package com.hcl.Irctc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties.Identityprovider.Verification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.hcl.Irctc.dto.BookingDto;
import com.hcl.Irctc.dto.Checking;
import com.hcl.Irctc.model.Train;
import com.hcl.Irctc.model.User;
import com.hcl.Irctc.service.BookingService;
import com.hcl.Irctc.service.TrainService;
import com.hcl.Irctc.service.UserService;


@RestController
public class BookingContoller {
	
	
	@Autowired
	TrainService trainservice;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	BookingService bookingservice;
	
	@PostMapping("/addtrain")
	public ResponseEntity<Train> saveTrain(@RequestBody Train train) {
       
		Train train1 = trainservice.InsertTrain(train);
        return new ResponseEntity<>(train1,  HttpStatus.CREATED);
    
	}
	
	

	
	@PostMapping("/trains/{source}/{destination}")
	public ResponseEntity<?> TrainSearch(@Valid @RequestBody Checking check, @PathVariable("source") String source, @PathVariable("destination") String destination  )  {
		return trainservice.search(check.getSource(), check.getDestination(), check.getDate());
		
	}
	
	
	@PostMapping("/tickets")
    public ResponseEntity<String> addToBooking(@RequestBody BookingDto bookingdto){
        User user = userservice.getUserById(bookingdto.getUserid());	 
        Train train = trainservice.getTrainById(bookingdto.getTrainid());
        if(user != null && train!= null) {
        	bookingservice.addToBooking(train, user);
        return new ResponseEntity<String>("Booking Done", HttpStatus.CREATED);

    } return new ResponseEntity<String>("Give proper Inputs", HttpStatus.BAD_REQUEST);
        }
	
	

}

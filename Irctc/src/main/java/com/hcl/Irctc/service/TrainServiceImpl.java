package com.hcl.Irctc.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.Irctc.GlobalLogger;
import com.hcl.Irctc.controller.BookingContoller;
import com.hcl.Irctc.dao.BookingDao;
import com.hcl.Irctc.dao.TrainDao;
import com.hcl.Irctc.dto.Check;
import com.hcl.Irctc.exception.TicketNotFoundException;
import com.hcl.Irctc.exception.TrainNotFoundException;
import com.hcl.Irctc.model.Booking;
import com.hcl.Irctc.model.Days;
import com.hcl.Irctc.model.Train;
import com.hcl.Irctc.model.User;


@Service
public class TrainServiceImpl implements TrainService {

	private Logger logger = GlobalLogger.getLogger(BookingContoller.class);
	@Autowired
	TrainDao traindao;

	

	@Override
	public Train InsertTrain(Train train) {
		logger.info("Train Details are saved to Database");
		return traindao.save(train);
	}
	
	@Override
	public List<Train> SearchTrains(Check s5) throws ParseException, TrainNotFoundException{
		
		int currentdate= new SimpleDateFormat("yyyy-MM-dd").format(new Date()).compareTo(s5.getDate());
		
		Date format = new SimpleDateFormat("yyyy-MM-dd").parse(s5.getDate());
	
        logger.info("     " + format + "    ");
		
        DateFormat format2=new SimpleDateFormat("EEEE"); 
        String finalDay=format2.format(format);
		
        
        String s3 = finalDay.substring(0, 2);	
		
      
		List<Train> trains =  traindao.findBySourceAndDestinationAndDays(s5.getSource(),s5.getDestination(),Days.valueOf(s3));
		
       if(currentdate >= 1) {
    	 logger.info("Previous Days it will take");
    	throw new TrainNotFoundException("Please Provide cureent or, Future date");
		}
       
       if(s5.getSource().equalsIgnoreCase(s5.getDestination())) {
      	 logger.info("It will take source and destination");
       	throw new TrainNotFoundException("Source And Destination Should Not Be Same");
   		}
   	
	
     	if(!trains.isEmpty()) {
     		logger.info("train are found");
     		return trains;
     	}
          throw new TrainNotFoundException("Train Not Found");
	}

	
	

	
	public Train getTrainById(Integer trainid) {
        Optional<Train> optionalTrain = traindao.findById(trainid);
        if (!optionalTrain.isPresent())
        {
            return null;	
        }
        return optionalTrain.get();
    }

	
}

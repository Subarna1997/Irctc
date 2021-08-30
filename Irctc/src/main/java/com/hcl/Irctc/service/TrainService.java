package com.hcl.Irctc.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.Irctc.dto.Check;
import com.hcl.Irctc.exception.TrainNotFoundException;
import com.hcl.Irctc.model.Booking;
import com.hcl.Irctc.model.Days;
import com.hcl.Irctc.model.Train;

@Service
public interface TrainService {
	

	Train InsertTrain(Train train);
	
	
	//public List<Train> SearchTrains(String source, String destination, Date date);
		
	public Train getTrainById(Integer trainid);
	public List<Train> SearchTrains(Check s5) throws ParseException,TrainNotFoundException;


	//List<Train> getTrainsList(String source, String destination, String date);


	//ResponseEntity<?> search(String source, String destination, Date date);
	
	


}

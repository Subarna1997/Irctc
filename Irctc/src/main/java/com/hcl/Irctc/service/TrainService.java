package com.hcl.Irctc.service;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.Irctc.model.Days;
import com.hcl.Irctc.model.Train;

@Service
public interface TrainService {
	
	public ResponseEntity<?> search(String source, String destination, Date date) ;

	Train InsertTrain(Train train);
	
	public Train getTrainById(Integer trainid);

}

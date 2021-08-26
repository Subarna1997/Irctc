package com.hcl.Irctc.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.Irctc.dao.TrainDao;
import com.hcl.Irctc.model.Days;
import com.hcl.Irctc.model.Train;
import com.hcl.Irctc.model.User;


@Service
public class TrainServiceImpl implements TrainService {

	@Autowired
	TrainDao traindao;

	@Override
	public ResponseEntity<?> search(String source, String destination, Date date) {

		List<Train> trains = traindao.findAll();

		List<Train> s3 = new ArrayList<Train>();

		DateFormat formatter = new SimpleDateFormat("EEEE");
		System.out.println( " "+ formatter.format(date) + " ");

		char[] s9 = formatter.format(date).toCharArray();
		String s7 = String.valueOf(s9[0]) + String.valueOf(s9[1]);

		for (Train s1 : trains) {

			for (Days s4 : s1.getDay()) {

				// System.out.println(s4 + " ");
				if (s4.toString().equals(s7)) {

					// System.out.print( s1.getTrainname() +" ");

					
//					if (s1.getSeats() == 0) {
//						System.out.print( s1.getTrainname() +" ");
//						return new ResponseEntity<String>("Ticket Not Available!!  Try Another Date ", HttpStatus.OK);
//					}

					if (s1.getSource().equals(source) && s1.getDestination().equals(destination)) {
						s3.add(s1);
						
					
					if (s1.getSource().equals(source) ^ s1.getDestination().equals(destination)) {
						return new ResponseEntity<String>("Train Not Found !!", HttpStatus.OK);
					}
					
				}
				}
			}
				
		}
		return new ResponseEntity<List<Train>>(s3, HttpStatus.OK);

	}

	@Override
	public Train InsertTrain(Train train) {
		return traindao.save(train);
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

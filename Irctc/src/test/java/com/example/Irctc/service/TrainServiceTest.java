package com.example.Irctc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hcl.Irctc.dao.TrainDao;
import com.hcl.Irctc.dto.Check;
import com.hcl.Irctc.exception.TrainNotFoundException;
import com.hcl.Irctc.model.Days;
import com.hcl.Irctc.model.Train;
import com.hcl.Irctc.service.TrainServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TrainServiceTest {
	
	@Mock
	TrainDao traindao;
	
	@InjectMocks
	TrainServiceImpl trainservice;
	
	static Train train;
	static List<Days> days;
	static Days days1;
	static Check check;
	@BeforeAll
	public static void setup() {
		
		train = new Train();
		train.setDays(days);
		train.setDestination("DEL");
		train.setSource("CSMT");
		train.setPrice(123);
		train.setSeats(12);
		train.setTrainid(1);
		train.setTrainname("Rajdhani");
		train.setTrainno(12356);
		
		check= new Check();
		check.setDate("2021-08-27");
		check.setDestination("KOL");
		check.setSource("KGP");
	}
	
	@Test
	@DisplayName("Save Train")
	public void save() {
		
		//when
		when(traindao.save(train)).thenReturn(train);
		
		//then
		trainservice.InsertTrain(train);
		
		//outcome
		assertEquals(train,trainservice.InsertTrain(train));
		
	}
	
//	@Test
//	@DisplayName("Train Search : Positive")
//	public void search1() throws ParseException, TrainNotFoundException {
//		//given
//		List<Train> trains = new ArrayList<Train>();
//		trains.add(train);
//		//when(traindao.findBySourceAndDestinationAndDays("Del", "kol",  days1));
//		
//		//when
//		List<Train> result = trainservice.SearchTrains(check);
//		
//		//outcome
//		assertEquals(trains,result);
//	}
	
	@Test
	@DisplayName("Train Search : negative")
	public void search2() {
		//when(traindao.findBySourceAndDestinationAndDays("kgp", "kol", days1)).thenThrow(TrainNotFoundException));
        assertThrows(TrainNotFoundException.class, () ->trainservice.SearchTrains(check));
}
}

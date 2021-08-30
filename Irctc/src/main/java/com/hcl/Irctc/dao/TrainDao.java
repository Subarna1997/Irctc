package com.hcl.Irctc.dao;




import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.Irctc.model.Days;
import com.hcl.Irctc.model.Train;

@Transactional
@Repository
public interface TrainDao extends JpaRepository<Train,Integer>{
	
	List<Train> findBySourceAndDestinationAndDays(String source, String destination,Days days );
	
	 Train findByTrainid(int trainid);
}

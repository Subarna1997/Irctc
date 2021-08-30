package com.hcl.Irctc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.Irctc.model.Booking;

;

@Transactional
@Repository
public interface BookingDao extends JpaRepository<Booking, Integer> {
	
	@Query("from Booking,User u where u.userId =:userId ")
	List<Booking> getBooking(int userId);

}
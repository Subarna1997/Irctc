package com.hcl.Irctc.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.Irctc.model.Booking;

;

@Transactional
@Repository
public interface BookingDao extends JpaRepository<Booking, Integer> {

}
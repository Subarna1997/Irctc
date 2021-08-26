package com.hcl.Irctc.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.Irctc.model.User;

@Transactional
@Repository
public interface UserDao extends JpaRepository<User,Integer> {
	
	User findByUserNameAndPassword(String userName, String password);

	// User findByUserId(int userId);

}

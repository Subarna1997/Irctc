package com.hcl.Irctc.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.Irctc.dto.UserDto;
import com.hcl.Irctc.model.User;

@Service
public interface UserService {
	
	public ResponseEntity<?> userLogin(String userName);


	public ResponseEntity<String> otp(int userId,long otp);

}

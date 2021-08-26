package com.hcl.Irctc.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hcl.Irctc.dto.UserDto;
import com.hcl.Irctc.model.User;

@Service
public interface UserService {
	
	public User getUserById(Integer userid);
	
	boolean saveUserDetails(UserDto userDto);

	 ResponseEntity<String> authenticate(String username, String password);

}

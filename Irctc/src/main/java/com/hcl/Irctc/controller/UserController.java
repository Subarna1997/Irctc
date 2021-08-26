package com.hcl.Irctc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.Irctc.dto.UserCredentials;
import com.hcl.Irctc.dto.UserDto;
import com.hcl.Irctc.service.UserService;

@RestController
public class UserController {
	
@Autowired
UserService userservice;
	
@PostMapping("/users/login")
public ResponseEntity<String> login(@Valid @RequestBody UserCredentials credentials) {
return userservice.authenticate(credentials.getUsername(), credentials.getPassword());
}


@PostMapping("/users")
public String register(@RequestBody UserDto userdto) {

boolean isSaved = userservice.saveUserDetails(userdto);
if(isSaved) return "Registration Successful";
return "Registration failed";
}

}

package com.hcl.Irctc.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.Irctc.GlobalLogger;

import com.hcl.Irctc.dto.UserDto;
import com.hcl.Irctc.dto.UserOtpDto;
import com.hcl.Irctc.model.User;
import com.hcl.Irctc.service.UserService;

import io.swagger.annotations.ApiOperation;

@ApiOperation(value="User Controller", tags="User Controller Generator")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	static Logger logger = LoggerFactory.getLogger(UserController.class);

	 @PostMapping("/users/otp")
	public ResponseEntity<?> otpvalidate(@Valid @RequestBody UserOtpDto userotpdto) {

	 return userService.otp(userotpdto.getUserId(), userotpdto.getOtp());
	}

	 @PostMapping("/users")
	public ResponseEntity<?> sendotp(@RequestBody @Valid UserDto userDto) {

	 return userService.userLogin(userDto.getUserName());


}
	 
}

package com.hcl.Irctc.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



public class UserDto {

	@NotNull
	private String userName;

	 public String getUserName() {
	return userName;
	}

	 public void setUserName(String userName) {
	this.userName = userName;
	}

}

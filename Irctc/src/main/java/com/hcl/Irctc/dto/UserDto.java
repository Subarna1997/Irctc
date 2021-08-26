package com.hcl.Irctc.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



public class UserDto {

	
	
	@NotEmpty(message = "feilds should not be empty")
	private String userName;
	@Email(message = "emaild id should be in proper format")
	private String email;
	@NotNull(message = "mobile number should be in proper format")
	@Pattern(regexp = "[0-9]{10}$")
	private long mobileNo;
	
	
	private String password;
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
	return userName;
	}
	public void setUserName(String userName) {
	this.userName = userName;
	}
	public String getEmail() {
	return email;
	}
	public void setEmail(String email) {
	this.email = email;
	}
	public long getMobileNo() {
	return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
	this.mobileNo = mobileNo;
	}
}

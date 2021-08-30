package com.example.Irctc.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;

import com.hcl.Irctc.controller.UserController;
import com.hcl.Irctc.dto.UserDto;
import com.hcl.Irctc.dto.UserOtpDto;
import com.hcl.Irctc.exception.InvalidCrdentialsException;
import com.hcl.Irctc.exception.UserIdNotFoundException;
import com.hcl.Irctc.model.User;
import com.hcl.Irctc.service.UserServiceImpl;



@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
@Mock
UserServiceImpl userService;
@InjectMocks
UserController userController;
static User user;
static UserDto userDto;
static SimpleMailMessage msg;
static UserOtpDto userOtpDto;
@BeforeAll
public static void setUp() {
user=new User();
user.setUserId(1);
user.setUserName("brundasai");
user.setPhoneNumber("887535886");
user.setEmail("brundasaibhupalam@gmail.com");
user.setOtp(7893749L);
List<UserOtpDto>userOtpData=new ArrayList<UserOtpDto>();
userOtpData.getClass();
msg=new SimpleMailMessage();
msg.setFrom("brundasaibhupalam@gmail.com");
msg.setTo("brundasaibhupalam@gmail.com");
msg.setSubject("Check Otp");
msg.setText("This is your logign otp"+user.getOtp());
}
@Test
@DisplayName("LoginFunctino Name:negative Scenario")
public void loginTest1() {
when(userService.userLogin("virat")).thenThrow(UserIdNotFoundException.class);
assertThrows(UserIdNotFoundException.class,()->userController.sendotp(userDto));
}
// @Test
// @DisplayName("OTp Validation:Positive scenario")
// public void otpvalidtest() {
// when(userService.otp(1L,7893749L)).thenReturn(
// new ResponseEntity<String>("Login Success",HttpStatus.OK));
// ResponseEntity<String> result=userController.otpvalidate(userOtpDto);
// verify(userService).otp(1L, 7893749L);
// assertEquals("Login Success",result.getBody());
// assertEquals(HttpStatus.OK,result.getStatusCode());
// }
@Test
@DisplayName("OTp Validation")
public void otpvalidTest1() {
when(userService.otp(1, 7893749L)).thenThrow(InvalidCrdentialsException.class);
assertThrows(InvalidCrdentialsException.class,()->userController.otpvalidate(userOtpDto));
}
@Test
@DisplayName("otp validation Negative")
public void otpvalidTest2() {
when(userService.otp(1, 7893749L)).thenThrow(InvalidCrdentialsException.class);
assertThrows(InvalidCrdentialsException.class,()->userController.otpvalidate(userOtpDto));
}


}
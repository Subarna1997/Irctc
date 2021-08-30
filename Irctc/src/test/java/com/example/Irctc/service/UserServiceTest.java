package com.example.Irctc.service;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.hcl.Irctc.dao.UserDao;
import com.hcl.Irctc.exception.InvalidCrdentialsException;
import com.hcl.Irctc.exception.UserIdNotFoundException;
import com.hcl.Irctc.model.User;
import com.hcl.Irctc.service.UserServiceImpl;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
@Mock
UserDao userRepository;
@Mock
JavaMailSender javaMailSender;
@InjectMocks
UserServiceImpl userServiceImpl;
//static Optional<User> user1;
static Optional<User> user;
static User user1;
static SimpleMailMessage msg;
@BeforeAll
public static void setUp() {

 user1=new User();
user1.setUserId(1);
user1.setUserName("brundasai");
user1.setPhoneNumber("9908176684");
user1.setEmail("brundasaibhupalam@gmail.com");
user1.setOtp(7893749L);
user=Optional.of(user1);

 msg=new SimpleMailMessage();
msg.setFrom("brundasaibhupalam@gmail.com");
msg.setTo("brundasaibhupalam@gmail.com");
msg.setSubject("Check Otp");
msg.setText("This is your logign otp"+user1.getOtp());
}
@Test
@DisplayName("Login Function:positive scenario")
public void loginTest() {
when(userRepository.findByUserName(user1.getUserName())).thenReturn(user1);
when(userRepository.save(user1)).thenAnswer(i->{
Random rand=new Random();
user1.setOtp(rand.nextLong());
return user1;
});
ResponseEntity<?> result=userServiceImpl.userLogin(user1.getUserName());
verify(userRepository).findByUserName(user1.getUserName());
verify(userRepository).save(user1);
//assertEquals("11"+user1.getUserId(),result.getBody());
assertEquals(HttpStatus.OK,result.getStatusCode());
}
@Test
@DisplayName("Login Function:Negative Scenario")
public void login() {
when(userRepository.findByUserName(user1.getUserName())).thenThrow(UserIdNotFoundException.class);
assertThrows(UserIdNotFoundException.class, ()->userServiceImpl.userLogin(user1.getUserName()));
}
@Test
@DisplayName("Otp validation :positive secnario")
public void otpValidation() {
when(userRepository.findById(1)).thenReturn(user);
ResponseEntity<String> result=userServiceImpl.otp(user1.getUserId(), user1.getOtp());
verify(userRepository).findByUserId(1);
assertEquals("Login Successfull",result.getBody());
assertEquals(HttpStatus.OK,result.getStatusCode());
}
@Test
@DisplayName("otp validation ")
public void otpValidationTest() {
when(userRepository.findByUserId(1)).thenThrow(InvalidCrdentialsException.class);
assertThrows(InvalidCrdentialsException.class,()->userServiceImpl.otp(user1.getUserId(),user1.getOtp()));
}
// @Test
// @DisplayName("otp validation:Negative scenario 2")
// public void otpvalidTest() {
// when(userRepository.findByUserId(1L)).thenThrow(UserIdNotFoundException.class);
// assertThrows(UserIdNotFoundException.class,()->userServiceImpl.otp(user1.getUserId(),user1.getOtp()));
// }



}
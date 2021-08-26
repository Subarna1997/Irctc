package com.hcl.Irctc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    private String email;
    private long mobileNo;
   // private static final long OTP_VALID_DURATION = 5 * 60 * 1000;
    
    private String password;
    //@Column(name = "otp_requested_time")
   // private Date otpRequestedTime;
     
     
//    public boolean isOTPRequired() {
//        if (this.getOneTimePassword() == null) {
//            return false;
//        }
//         
//        long currentTimeInMillis = System.currentTimeMillis();
//        long otpRequestedTimeInMillis = this.otpRequestedTime.getTime();
//         
//        if (otpRequestedTimeInMillis + OTP_VALID_DURATION < currentTimeInMillis) {
//            // OTP expires
//            return false;
//        }
//         
//        return true;
//    }
//     
//    private Object getOneTimePassword() {
//        // TODO Auto-generated method stub
//        return null;
//    }

 

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
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
//    public int getOtp() {
//        return otp;
//    }
//    public void setOtp(int otp) {
//        this.otp = otp;
//    }
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
    

 

}
 







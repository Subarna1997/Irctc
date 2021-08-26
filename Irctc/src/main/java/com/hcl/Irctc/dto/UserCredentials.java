package com.hcl.Irctc.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UserCredentials {
@NotEmpty(message = "Username not be empty")
private String username;
@NotEmpty(message = "Password not be empty")
//@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$")
private String password;
public String getUsername() {
return username;
}
public void setUsername(String username) {
this.username = username;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}
}

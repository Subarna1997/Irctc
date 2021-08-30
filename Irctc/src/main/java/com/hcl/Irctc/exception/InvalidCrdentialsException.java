package com.hcl.Irctc.exception;

public class InvalidCrdentialsException extends RuntimeException {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
String str;

 public InvalidCrdentialsException(String str) {
super();
this.str = str;
}

 public String getStr() {
return str;
}

 public void setStr(String str) {
this.str = str;
}

}

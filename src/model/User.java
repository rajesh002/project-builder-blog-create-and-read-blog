package model;

import java.time.LocalDate;

public class User{
	private String email;
	private String password;
//	private String confirmpassword;
	private LocalDate date;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public String getConfirmpassword() {
//		return confirmpassword;
//	}
//	public void setConfirmpassword(String confirmpassword) {
//		this.confirmpassword = confirmpassword;
//	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
package com.cakeshop_springapi.Validation;

import com.cakeshop_springapi.model.User;

public class UserValidation {
	public static void validate(User user) throws Exception {
		if (user.getName() == null || user.getName().trim() == "") {
			throw new Exception("Invalid Name");
		}
		if (user.getEmail() == null || user.getEmail().trim() == "") {
			throw new Exception ("invalid Email id");
		}
		if (user.getPassword() == null || user.getPassword().trim().equals("")) {
			throw new Exception("Invalid Password");
		} else if (user.getPassword().length() < 8) {
			throw new Exception("Password must be minimum 8 characters");
		}
		if (user.getNumber() == null || ((String) user.getNumber()).length()  <10) {
			throw new Exception("number must be in 10 digits");
		}
		
	}
	public static void loginvalidate(User user) throws Exception {
		if (user.getEmail() == null || user.getEmail().trim().equals("")||!(user.getEmail()).contains("@gmail.com")) {
			throw new Exception("Invalid email. email cannot be empty/blank");
		}
		if (user.getPassword() == null || user.getPassword().length() < 8) {
			throw new Exception("password must be in 8 characters");
		}
//		if (user.getRole() != null ) {
//		} else {
//			throw new Exception("The role cannot be empty");
//		}
		System.out.println("You have login successfully");

	
}
}
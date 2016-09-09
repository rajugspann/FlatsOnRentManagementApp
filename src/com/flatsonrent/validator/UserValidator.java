package com.flatsonrent.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.flatsonrent.model.User;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {

		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		User user = (User)command;
		if(user.getUsername() == null || user.getUsername().length()==0){
			errors.rejectValue("username", "errors.username.required", null, "Username Required.");
		}
		if(user.getPassword() == null || user.getPassword().length()==0){
			errors.rejectValue("password", "errors.password.required", null, "Password Required.");
			
		}
	}

}

package com.flatsonrent.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.flatsonrent.model.Register;
import com.flatsonrent.model.User;

public class RegisterValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {

		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		Register register = (Register)command;
		if(register.getUsername() == null || register.getUsername().length()==0){
			errors.rejectValue("username", "errors.username.required", null, "Username Required.");
		}
		if(register.getPassword() == null || register.getPassword().length()==0){
			errors.rejectValue("password", "errors.password.required", null, "Password Required.");
			
		}
		if(register.getName() == null || register.getName().length()==0){
			errors.rejectValue("name", "errors.name.required", null, "Password Required.");
			
		}
		if(register.getPhone() == null || register.getPhone().length()==0){
			errors.rejectValue("phone", "errors.phone.required", null, "Phone Required.");
			
		}
		if(register.getAddress() == null || register.getAddress().length()==0){
			errors.rejectValue("address", "errors.address.required", null, "Address Required.");
			
		}
		if(register.getPincode() == null || register.getPincode().length()==0){
			errors.rejectValue("pincode", "errors.pincode.required", null, "Pincode Required.");
			
		}
		if(register.getCity() == null || register.getCity().length()==0){
			errors.rejectValue("city", "errors.city.required", null, "City Required.");
			
		}
		if(register.getState() == null || register.getState().length()==0){
			errors.rejectValue("state", "errors.state.required", null, "State Required.");
			
		}
	}

}

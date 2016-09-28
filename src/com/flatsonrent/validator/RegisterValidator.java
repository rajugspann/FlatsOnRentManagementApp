package com.flatsonrent.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.flatsonrent.model.Register;
import com.flatsonrent.model.User;

public class RegisterValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {

		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		Register register = (Register) command;
		if (register.getUsername() == null
				|| register.getUsername().length() == 0) {
			errors.rejectValue("username", "errors.username.required", null,
					"Username Required.");
		}
		if ((register.getUsername().length() > 0 && register.getUsername()
				.length() < 3) || register.getUsername().length() > 6) {
			errors.rejectValue("username", "errors.username.lenth", null,
					"Lenth should be  between 3 and 6.");
		}
		if ((register.getPassword().length() > 0 && register.getPassword()
				.length() < 4) || register.getPassword().length() > 8) {
			errors.rejectValue("username", "errors.password.lenth", null,
					"Lenth should be  between 4 and 8.");
		}
		if (register.getPassword() == null
				|| register.getPassword().length() == 0) {
			errors.rejectValue("password", "errors.password.required", null,
					"Password Required.");

		}
		String REGEX = "^[&%$##@!~]";
		String username = register.getName();
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(username);
		if (register.getName() == null || register.getName().length() == 0) {
			errors.rejectValue("name", "errors.name.required", null,
					"Password Required.");

		} else if (matcher.matches()) {
			errors.rejectValue("name", "errors.name.character", null,
					"Special character is now allowed");

		}
		if (register.getPhone() == null || register.getPhone().length() == 0) {
			errors.rejectValue("phone", "errors.phone.required", null,
					"Phone Required.");

		}
		if (register.getAddress() == null
				|| register.getAddress().length() == 0) {
			errors.rejectValue("address", "errors.address.required", null,
					"Address Required.");

		}
		if (register.getPincode() == null
				|| register.getPincode().length() == 0) {
			errors.rejectValue("pincode", "errors.pincode.required", null,
					"Pincode Required.");

		}
		if (register.getCity() == null || register.getCity().length() == 0) {
			errors.rejectValue("city", "errors.city.required", null,
					"City Required.");

		}
		if (register.getState() == null || register.getState().length() == 0) {
			errors.rejectValue("state", "errors.state.required", null,
					"State Required.");

		}
	}

}

package com.flatsonrent.controller;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flatsonrent.hibernate.ChibernateUtil;
import com.flatsonrent.model.Register;
import com.flatsonrent.model.User;
import com.flatsonrent.validator.RegisterValidator;

@Controller
public class RegisterController {
	@Autowired
	 private RegisterValidator registerValidator;

	@RequestMapping(value = "/register")
	protected String loginPage(Map model) throws Exception {
		Register register = new Register();
		model.put("register", register);
		return "register";
	}
	
	@RequestMapping(value = "verifyUserOnRegistration", method = RequestMethod.POST)
	public String verifyUser(@ModelAttribute("register") Register register,
			BindingResult result) {
		registerValidator.validate(register, result);
		if (result.hasErrors()) {
			return "register";
		}
		String username = register.getUsername();
		String password = register.getPassword();
		String name = register.getName();
		String phone = register.getPhone();
		String address = register.getAddress();
		String state = register.getState();
		String city = register.getCity();
		String pincode = register.getPincode();
		if (!username.isEmpty() || !password.isEmpty() || !phone.isEmpty()  || !address.isEmpty()  || !state.isEmpty()  || !city.isEmpty()  || !pincode.isEmpty() || !name.isEmpty() ) {
			// Hibernate code to connect with database;
			Transaction txn = null;
			Session session = null;
			try{
				System.out.println("das");
			SessionFactory factory = ChibernateUtil.getSessionFctory();
			 session = factory.openSession();
			txn = session.beginTransaction();
			//fetching all the record from database.
			Register register2 = new Register(username, password, name, phone, address, pincode, city, state);
			session.save(register2);
			txn.commit();
			System.out.println("Transaction : "+ txn);
			}catch(Exception e){
				if(txn!=null)
					txn.rollback();
			}
			
		}
		return "registersuccess";
		
}}

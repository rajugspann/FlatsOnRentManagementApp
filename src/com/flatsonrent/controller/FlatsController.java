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
import com.flatsonrent.validator.UserValidator;

@Controller
public class FlatsController{

	@Autowired
	private UserValidator userValidator;
	SessionFactory factory = ChibernateUtil.getSessionFctory();
	@RequestMapping(value = "verifyUser", method = RequestMethod.POST)
	public String verifyUser(@ModelAttribute("user") User user,
			BindingResult result) {
		String un = user.getUsername();
		String pw = user.getPassword();
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "login";
		}
		if (!un.isEmpty() || !pw.isEmpty()) {
			// Hibernate code to connect with database;
			Session session = null;
			Transaction txn = null;
			try{
			
			session = factory.openSession();
			System.out.println("Session Object : "+session);
			txn = session.beginTransaction();
			//fetching all the record from database.
			List<Register> list = session.createCriteria(Register.class).list();
			for(Register dbUsers : list){
				String username = dbUsers.getUsername();
				String password = dbUsers.getPassword();
				System.out.println(username);
				System.out.println(password);
			if (un.equals(username)
					&& pw.equals(password)) {
				return "home";
			}
			}
			}catch(Exception e){
				if(txn!=null)
					txn.rollback();
			}
			
		}
		return "login";
	}

	@RequestMapping(value = "/login")
	protected String loginPage(Map model) throws Exception {
		User user = new User();
		model.put("user", user);
		return "login";
	}

}

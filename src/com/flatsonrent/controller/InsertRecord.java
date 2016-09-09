package com.flatsonrent.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flatsonrent.hibernate.ChibernateUtil;
import com.flatsonrent.model.User;

public class InsertRecord {
	public static void main(String[] args) {
		Session session = null;
		Transaction txn = null;
		try {
			SessionFactory factory = ChibernateUtil.getSessionFctory();
			session = factory.openSession();
			txn = session.beginTransaction();
			User user = new User("raju", "sharma");
			session.save(user);
			txn.commit();
		} catch (Exception e) {
			if (txn != null)
				txn.rollback();
		}

	}
}

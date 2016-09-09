package com.flatsonrent.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ChibernateUtil {
	public static Configuration configuration = null;
	static SessionFactory sessionfactory;

	static {
		configuration = new Configuration();
		configuration = configuration.configure("com/flatsonrent/resource/hibernate.cfg.xml");
		sessionfactory = configuration.buildSessionFactory();
	}

	public static SessionFactory getSessionFctory() {

		return sessionfactory;
	}
	
	public static Session getCurrentSession(){
		return sessionfactory.getCurrentSession();
	}
}

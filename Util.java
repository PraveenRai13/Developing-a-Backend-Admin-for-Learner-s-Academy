package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import AllDetails.ClassDetails;
import AllDetails.StudentDetails;
import AllDetails.SubjectDetails;
import AllDetails.TeacherDetails;

public class Util {
	private static SessionFactory factory;
	
	public static SessionFactory buildConnection() {
		
		factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(StudentDetails.class)	
				.addAnnotatedClass(TeacherDetails.class)
				.addAnnotatedClass(ClassDetails.class)
				.addAnnotatedClass(SubjectDetails.class)
				.buildSessionFactory();
		
		return factory;
	}

}

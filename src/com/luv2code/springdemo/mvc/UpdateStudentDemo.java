package com.luv2code.springdemo.mvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.springdemo.entity.Student;

public class UpdateStudentDemo {
	public static void main(String Args[]) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session 
		Session session = factory.getCurrentSession();
		
		try {
			//MY NEW CODE
			//find out the student's id: primary key 
			int studentId = 1;
			//now get a new session and start transaction 
			session = factory.getCurrentSession();
			session.beginTransaction(); 
			
			Student myStudent = session.get(Student.class, studentId);
			myStudent.setFirstName("Scooby");
			// retrieve student based on the id: primary key 
			
			//commit the transaction 
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
		
	}	
}

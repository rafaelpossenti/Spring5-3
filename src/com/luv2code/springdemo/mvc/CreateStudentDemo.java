package com.luv2code.springdemo.mvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.springdemo.entity.Student;

public class CreateStudentDemo {
	public static void main(String Args[]) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session 
		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			Student tempStudent = new Student("Paul","wall","paul@coldmail.com");
			
			// start a transaction 
			session.beginTransaction();
			
			//save the student object
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
		
	}	
}

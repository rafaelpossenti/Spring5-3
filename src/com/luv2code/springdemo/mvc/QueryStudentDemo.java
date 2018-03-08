package com.luv2code.springdemo.mvc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.springdemo.entity.Student;

public class QueryStudentDemo {
	public static void main(String Args[]) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session 
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction 
			session.beginTransaction();
			
			// query students 
			List<Student> theStudents = session.createQuery("from Student").list();
			
			// display the students 
			theStudents.forEach(System.out::println);
			
			//query students: lastName='Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").list();
			theStudents.forEach(System.out::println);
			
			//query students: email LIKE %luvcode.com
			theStudents = session.createQuery("from Student s where s.email LIKE '%@coldmail.com                           '").list();
			theStudents.forEach(System.out::println);
			
			
			//commit transaction
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
		
	}	
}

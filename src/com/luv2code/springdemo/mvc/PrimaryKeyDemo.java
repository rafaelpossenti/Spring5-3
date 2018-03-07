package com.luv2code.springdemo.mvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.springdemo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
				
				//create session 
				Session session = factory.getCurrentSession();
				
				try {
					// create a student object
					Student tempStudent1 = new Student("John","Doe","doe@coldmail.com");
					Student tempStudent2 = new Student("Maria","alcatraz","maria@coldmail.com");
					Student tempStudent3 = new Student("vania","apple","vania@coldmail.com");
					
					// start a transaction 
					session.beginTransaction();
					
					//save the student object
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					//commit transaction
					session.getTransaction().commit();
					
				}finally {
					factory.close();
				}

	}

}

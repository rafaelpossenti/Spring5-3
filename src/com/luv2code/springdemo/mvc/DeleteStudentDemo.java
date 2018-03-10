package com.luv2code.springdemo.mvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.luv2code.springdemo.entity.Student;

public class DeleteStudentDemo {
	public static void main(String Args[]) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session 
		Session session = factory.getCurrentSession();
		
		try {
			//find out the student's id: primary key 
			int studentId = 1;
			
			//now get a new session and start transaction 
			session = factory.getCurrentSession();
			session.beginTransaction(); 
			
			//retrieve student based on the id
			Student myStudent = session.get(Student.class, studentId);
			
			//delete the student 
			//session.delete(myStudent);
			
			///delete student id=2
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			
			
			
			//commit the transaction 
			session.getTransaction().commit();
						
		}finally {
			factory.close();
		}
	}
}
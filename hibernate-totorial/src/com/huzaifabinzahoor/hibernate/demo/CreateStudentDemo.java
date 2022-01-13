package com.huzaifabinzahoor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.huzaifabinzahoor.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create student Object
			System.out.println("Creating new Student Object");
			Student tempStudent = new Student("Huzaifa Bin", "Zahoor", "huzaifazahoor4@gmail.com");
			
			// begin the transaction
			System.out.println("transaction is begining");
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student object in DB");
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done !!! ");

		} finally {
			factory.close();
		}
	}

}

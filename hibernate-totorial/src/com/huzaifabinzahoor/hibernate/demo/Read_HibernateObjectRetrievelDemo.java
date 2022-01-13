package com.huzaifabinzahoor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.huzaifabinzahoor.hibernate.demo.entity.Student;

public class Read_HibernateObjectRetrievelDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create student Object
			System.out.println("Creating new Student Object");
			Student tempStudent = new Student("Ahmed", "Munawar", "zing34wirlay@yahoo.com");

			// begin the transaction
			System.out.println("transaction is begining");
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student object in DB");
			System.out.println(tempStudent);
			session.save(tempStudent);

			// commit transaction
			session.getTransaction().commit();

			// My new Code for object retrieval

			// find out the student's primary key
			System.out.println("Saved Student. Generated ID is: " +tempStudent.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting Student with id: "+ tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get Complete: " +myStudent);
			
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done !!! ");

		} finally {
			factory.close();
		}
	}

}

package com.huzaifabinzahoor.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.huzaifabinzahoor.hibernate.demo.entity.Student;

public class Update_StudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id: primary key
			System.out.println("\nGetting Student with id: " + studentId);

			Student myStudent = session.get(Student.class, studentId);

			System.out.println("Updating Student...");
			myStudent.setFirstName("Scooooooby");

			// commit the transaction
			session.getTransaction().commit();

			// Experimenting, where I will be updating specific row of the DB
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id: primary key
			session.createQuery(
					"update Student set email='1234@yahoo.com' where lastName='Zahoor' AND firstName='Scooooooby' ")
					.executeUpdate();
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}

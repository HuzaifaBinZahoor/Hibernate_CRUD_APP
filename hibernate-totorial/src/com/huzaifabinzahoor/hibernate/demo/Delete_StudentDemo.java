package com.huzaifabinzahoor.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.huzaifabinzahoor.hibernate.demo.entity.Student;

public class Delete_StudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int studentId = 6;

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id: primary key
			System.out.println("\nGetting Student with id: " + studentId);

			Student myStudent = session.get(Student.class, studentId);
			
			// deleting the student
			System.out.println("Deleting Student: " + myStudent);
			session.delete(myStudent);
			
			// Alternate approach for deleting the object
			// let suppose with id=2
			session.createQuery("delete from Student where id=2").executeUpdate();

			// commit the transaction
			session.getTransaction().commit();

			// New code for deleting

		} finally {
			factory.close();
		}
	}

}

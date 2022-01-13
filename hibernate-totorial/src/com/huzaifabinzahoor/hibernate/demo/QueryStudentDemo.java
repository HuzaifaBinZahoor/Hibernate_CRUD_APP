package com.huzaifabinzahoor.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.huzaifabinzahoor.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// begin the transaction
			System.out.println("transaction is begining");
			session.beginTransaction();

			// query students
			List<Student> theStudents = session.createQuery("from Student").list();

			displayStudents(theStudents);

			// query students: lastName: 'Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").list();

			// display students
			System.out.println("Students with LastName: 'Doe' are as follow: ");
			displayStudents(theStudents);

			// query students: lastName: 'Doe' OR firstName: 'Huzaifa Bin'
			System.out.println("Students with lastName: 'Doe' OR firstName: 'Huzaifa Bin' are as follow:");
			theStudents = session
					.createQuery("from Student s where " + "s.lastName='Doe' OR s.firstName='Huzaifa Bin'").list();
			displayStudents(theStudents);

			// query where email LIKE 'gmail.com'
			System.out.println("/n /n /n Students with email ends: gmail.com");
			theStudents = session
					.createQuery("from Student s where " + "s.email LIKE '%gmail.com'").list();
			displayStudents(theStudents);

			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done !!! ");

		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}

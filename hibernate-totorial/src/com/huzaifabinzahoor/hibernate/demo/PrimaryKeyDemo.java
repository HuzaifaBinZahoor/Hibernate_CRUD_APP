package com.huzaifabinzahoor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.huzaifabinzahoor.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create 3 student Object
			System.out.println("Creating new Student Object");
			Student Student1 = new Student("Huzaifa Bin", "Zahoor", "huzaifazahoor4@gmail.com");
			Student Student2 = new Student("Anns Bin", "Zahoor", "annszahoor4@gmail.com");
			Student Student3 = new Student("Mushaf Bin", "Zahoor", "mushafzahoor4@gmail.com");
			Student Student4 = new Student("Reshiel Bin", "Zahoor", "reshielzahoor4@gmail.com");

			// begin the transaction
			System.out.println("transaction is begining");
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student object in DB");
			session.save(Student1);
			session.save(Student2);
			session.save(Student3);
			session.save(Student4);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done !!! ");

		} finally {
			factory.close();
		}
	}

}

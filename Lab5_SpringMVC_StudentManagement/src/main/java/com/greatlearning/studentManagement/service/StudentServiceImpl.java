package com.greatlearning.studentManagement.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.studentManagement.entity.Student;

@Repository
public class StudentServiceImpl implements StudentService {

	Session session;

	// @Autowired helps to inject all the dependencies needed; all the info is in the spring-mvc-servlet.xml file
	@Autowired
	StudentServiceImpl(SessionFactory sessionFactory) {
		// if you are firing your first request to the server it will go to the catch block because there will be no session for the first time and hibernate will throw exception that will be handled by catch block. catch block will open the session.
		// for all the further request it will go to the try block
		try {
			session = sessionFactory.getCurrentSession();
		} catch(HibernateException e) {
			session = sessionFactory.openSession();
		}
	}

	@Transactional
	public List<Student> findAll() {

		Transaction tx = session.beginTransaction();

		List<Student> students = session.createQuery("from Student").list();

		tx.commit();

		return students;
	}

	@Transactional
	public Student findById(int theId) {

		Student student = new Student();

		Transaction tx = session.beginTransaction();

		student = session.get(Student.class, theId);

		tx.commit();

		return student;
	}

	@Transactional
	public void save(Student theStudent) {

		Transaction tx = session.beginTransaction();

		session.saveOrUpdate(theStudent);

		tx.commit();

	}

	@Transactional
	public void deleteById(int theId) {

		Transaction tx = session.beginTransaction();

		// get transaction
		Student book = session.get(Student.class, theId);

		// delete record
		session.delete(book);

		tx.commit();

	}

}

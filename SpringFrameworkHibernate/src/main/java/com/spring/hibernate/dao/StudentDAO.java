package com.spring.hibernate.dao;


//import javax.transaction.Transactional;

//import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.spring.hibernate.entities.Student;



@Repository
public class StudentDAO {
	
	//@Autowired
	//private HibernateTemplate hibernateTemplate; 
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//@Transactional
	public void addStudent(Student student){
		Session session = sessionFactory.openSession(); 
		Transaction tx = null; 
		try {
			tx = session.beginTransaction(); 
			session.save(student);
			tx.commit();
		} catch (Exception e) {
			if (tx!=null) tx.rollback();
	         e.getMessage();
	         System.out.println("rollback");
		}finally {
			session.close();
		}
		
		//hibernateTemplate.save(student);
	}
	
	

}

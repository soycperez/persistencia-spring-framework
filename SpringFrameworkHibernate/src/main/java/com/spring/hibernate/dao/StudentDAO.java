package com.spring.hibernate.dao;


import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;

//import javax.transaction.Transactional;

//import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	public void listAll(){
		Session session = sessionFactory.openSession(); 
		Transaction tx = null; 
		try {
			tx = session.beginTransaction(); 
			List students = session.createQuery("FROM Student").list(); 
			for (Iterator iterator = students.iterator(); iterator.hasNext();){
				Student student = (Student) iterator.next(); 
				System.out.println("Studen id: " + student.getStudenId());
				System.out.println("Studen name: " + student.getStudentName());
				System.out.println("Studen city: " + student.getStudentCity());
				System.out.println("\n");
			}
			tx.commit(); 
		} catch (HibernateException e) {
			if(tx!= null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public void updateStudent(int id, Student student){
		Session session = sessionFactory.openSession(); 
		Transaction tx = null; 
		try {
			tx = session.beginTransaction(); 
			Student editStudent = (Student) session.get(Student.class, id);
			if(editStudent!=null){
				editStudent.setStudentName(student.getStudentName());
				editStudent.setStudentCity(student.getStudentCity());
				session.update(editStudent);
				tx.commit(); 
			}else System.out.println("No existe ese estudiante");
		} catch (HibernateException e) {
			if(tx!= null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}
	
	public void deleteStudent(int id){
		Session session = sessionFactory.openSession(); 
		Transaction tx = null; 
		try {
			tx = session.beginTransaction(); 
			Student deleteStudent = (Student) session.get(Student.class, id);
			if(deleteStudent!=null){
				session.delete(deleteStudent);
				tx.commit(); 
			}else System.out.println("NUll");
		} catch (HibernateException e) {
			if(tx!= null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public void findById(int id){
		Session session = sessionFactory.openSession(); 
		Transaction tx = null; 
		try {
			tx = session.beginTransaction(); 
			Student student = (Student) session.get(Student.class, id);
			if(student!=null){
				System.out.println("Student name: " + student.getStudentName() + "\n" +
									"Student City: " + student.getStudentCity());
				tx.commit(); 
			}else System.out.println("NUll");
		} catch (HibernateException e) {
			if(tx!= null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
}

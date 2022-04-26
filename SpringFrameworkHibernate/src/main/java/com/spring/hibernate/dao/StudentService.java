package com.spring.hibernate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.spring.hibernate.entities.Student;

@Service
public class StudentService implements IStudenService {
	
	@Autowired
	private HibernateTemplate hibernateTemplate; 
	
	public int insert(Student student){
		Integer i = (Integer)this.hibernateTemplate.save(student);
		return i; 
	}

}

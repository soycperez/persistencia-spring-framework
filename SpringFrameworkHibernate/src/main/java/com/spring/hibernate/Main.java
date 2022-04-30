package com.spring.hibernate;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.hibernate.config.DBConfig;
import com.spring.hibernate.dao.StudentDAO;
import com.spring.hibernate.entities.Student;

public class Main {

	public static void main(String[] args) {
		//Primer paso: Cargar el bean
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class); 
		
		
		//Asignar el bean al contenedor
		StudentDAO studentDAO = context.getBean(StudentDAO.class);
		
		//Student Cesar = new Student(10,"Jesica", "cdmx");
		//studentDAO.addStudent(Cesar);
		
		//studentDAO.listAll();
		
		//Actualizando student 
		//Student Cesar = new Student(11,"cesar", "cdmx");
		//studentDAO.updateStudent(Cesar.getStudenId(), Cesar);
		
		//Eleminando
		//studentDAO.deleteStudent(9);
		
		studentDAO.findById(10);
		
		context.close();
	}

}

package com.spring.hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.hibernate.config.DBConfig;
import com.spring.hibernate.dao.StudentService;

public class Main {

	public static void main(String[] args) {
		//Primer paso: Cargar el bean
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class); 
		
		//Asignar el bean al contenedor
		StudentService studentService = context.getBean(StudentService.class);

		context.close();
	}

}

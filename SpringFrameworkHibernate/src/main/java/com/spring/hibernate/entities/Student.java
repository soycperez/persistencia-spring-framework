package com.spring.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class Student {
	
	@Id
	@Column(name="studenId")
	private int studenId; 
	
	@Column(name="student_name")
	private String studentName; 
	
	@Column(name="student_city")
	private String studentCity;
	
	public Student() {

	}
	public Student(int studenId, String studentName, String studentCity) {
		super();
		this.studenId = studenId;
		this.studentName = studentName;
		this.studentCity = studentCity;
	}
	public int getStudenId() {
		return studenId;
	}
	public void setStudenId(int studenId) {
		this.studenId = studenId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentCity() {
		return studentCity;
	}
	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}
	
	
	
}

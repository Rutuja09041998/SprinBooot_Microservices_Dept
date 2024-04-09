package com.rutuja.CollegeService.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
@Component
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String collegeName;
	@Transient
	private List<Student> students;
	
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}

	public College(int id, String collegeName, List<Student> students) {
		super();
		this.id = id;
		this.collegeName = collegeName;
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", collegeName=" + collegeName + ", students=" + students + "]";
	}
	
	
	
}

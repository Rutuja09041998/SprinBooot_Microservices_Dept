package com.rutuja.StudentService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rutuja.StudentService.entity.Student;

@Repository
public interface Repo extends JpaRepository<Student, Integer> {

	List<Student> getByDepartmentId(int id);

}

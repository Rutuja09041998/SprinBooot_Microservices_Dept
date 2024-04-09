package com.rutuja.StudentService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rutuja.StudentService.entity.Student;
import com.rutuja.StudentService.repository.Repo;

@RestController
@RequestMapping("/Student")
public class rest {

	@Autowired
	private Repo repo;
	
	@PostMapping("/Save")
	public Student saveStudent(@RequestBody Student student) {
		return repo.save(student) ;
	}
	
	@GetMapping("/All")
	public List<Student> getAll(){
		return repo.findAll();
	}
	
	@GetMapping("/Get/{id}")
	public Student getById(@PathVariable int id) {
		Optional<Student> optional= repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@GetMapping("/GetByDept/{id}")
	public List<Student> getByDepartment(@PathVariable int id){
		return repo.getByDepartmentId(id);
	}
	
	
	
	
	
	
	
	
	
}

package com.rutuja.CollegeService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rutuja.CollegeService.entity.College;
import com.rutuja.CollegeService.entity.Student;
import com.rutuja.CollegeService.fingh.fiegn;
import com.rutuja.CollegeService.repository.Repo;

@RestController
@RequestMapping("/college")
public class rest {

	@Autowired
	private Repo repo;
	
	@Autowired
	private fiegn fiegn;
	
	@PostMapping("/save")
	public College saveCollege(@RequestBody College college) {
		return repo.save(college);
	}
	
	@GetMapping("/all")
	public List<College> allColleges(){
		List<College> listCollege=repo.findAll();
		return listCollege.stream().map(college->{
			List<Student> listOfStudent= fiegn.findByCollege(college.getId());
			college.setStudents(listOfStudent);
			return college;
		}).toList();
	}
		
	@GetMapping("/getByCollegeId/{id}")
	public College getByCollegeId(@PathVariable int id) {
		Optional<College> optional=repo.findById(id);
		if(optional.isPresent()) {
			College college=optional.get();
			List<Student> listStudent=fiegn.findByCollege(id);
			college.setStudents(listStudent);
			return college;
		}
		return null;	
	}
}

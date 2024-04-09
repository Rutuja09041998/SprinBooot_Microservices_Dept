package com.rutuja.CollegeService.fingh;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rutuja.CollegeService.entity.Student;

@FeignClient(name="StudentService")
public interface fiegn {

	@GetMapping("/All")
	public List<Student> getAll();
	
	@GetMapping("/Get/{id}")
	public Student getById(@PathVariable int id);
	
	@GetMapping("/GetByDept/{id}")
	public List<Student> findByCollege(@PathVariable int id);
}

package com.rutuja.CollegeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rutuja.CollegeService.entity.College;

@Repository
public interface Repo extends JpaRepository<College, Integer>{

}

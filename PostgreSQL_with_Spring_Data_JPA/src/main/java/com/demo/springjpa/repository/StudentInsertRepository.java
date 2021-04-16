package com.demo.springjpa.repository;

import org.springframework.stereotype.Repository;

import com.demo.springjpa.Student;

@Repository
public interface StudentInsertRepository {
	
	public void insertWithEntityManager(Student student);
}
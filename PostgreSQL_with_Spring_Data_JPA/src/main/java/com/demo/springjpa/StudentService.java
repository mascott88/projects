package com.demo.springjpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepo;

	public List<Student> findByName(String email) {
		return studentRepo.findByEmail(email);
	}
}

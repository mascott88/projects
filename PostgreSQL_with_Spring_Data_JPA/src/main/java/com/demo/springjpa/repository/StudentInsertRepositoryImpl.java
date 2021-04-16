package com.demo.springjpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.demo.springjpa.Student;

public class StudentInsertRepositoryImpl implements StudentInsertRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void insertWithEntityManager(Student student) {
		this.entityManager.persist(student);		
	}
}

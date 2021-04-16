package com.demo.springjpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.springjpa.repository.StudentInsertRepository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>, StudentInsertRepository {

	List<Student> findByEmail(String email);

	public void insertWithEntityManager(Student student);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM students WHERE id = :id", nativeQuery = true)
	void deleteByStudyId(@Param("id") Integer id);

}

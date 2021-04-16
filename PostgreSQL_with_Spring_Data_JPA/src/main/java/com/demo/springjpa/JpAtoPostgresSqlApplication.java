package com.demo.springjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpAtoPostgresSqlApplication implements CommandLineRunner{
	
	@Autowired
	StudentRepository studentRepo;

	public static void main(String[] args) {
		SpringApplication.run(JpAtoPostgresSqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		List<Student> students = studentRepo.findAll();
//		students.forEach(System.out :: println);
		Student student = new Student();
		student.setName("Rocky Scott");
		student.setEmail("test@email.com");
		studentRepo.insertWithEntityManager(student);
		studentRepo.deleteById(2);
		System.out.println(studentRepo.count());
//		System.exit(0);
	}
}
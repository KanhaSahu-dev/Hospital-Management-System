package com.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	public List<Student> findByName(String name);
	public Student findByEmailAndPassword(String email,String password);
	public Student findById(int id);
	
}

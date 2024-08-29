package com.org.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.dto.Student;
import com.org.repository.StudentRepository;
@Repository
public class StudentDao {
	@Autowired
	StudentRepository repo;
	public List<Student> fetchAllStudents;
	
	public Student saveStudent(Student std) {
		return repo.save(std);
	}

	public List<Student> fetchAllStudents() {
		
		List<Student> list = repo.findAll();
		
		return list;
	}

	public void deleteStudent(Student student) {
		
		repo.delete(student);
		
	}
	
	public Student findById(int id) {
		return repo.findById(id);
	}

	public List<Student> fetchByName(String name) {
		return repo.findByName(name);
	}

	public Student fetchByEmailAndPassword(String email,String password) {
		return repo.findByEmailAndPassword(email, password);
	}
	
	public Student updateById(int id,Student std) {
		repo.save(std);
		
		return repo.findById(id);
	}
	
}

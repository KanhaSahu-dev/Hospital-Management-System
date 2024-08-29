package com.org.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.dao.StudentDao;
import com.org.dto.Student;

@RestController
@RequestMapping("/Student")
@CrossOrigin(origins = "http://example.com")
public class StudentController {
	
	@Autowired
	StudentDao studentDao;
	
	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student saveStudent = studentDao.saveStudent(student);
		return new ResponseEntity<Student>(saveStudent,HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public List<Student> fetchAll(){
		return studentDao.fetchAllStudents();
	}
	
	@DeleteMapping("/delete")
	public String deleteStudent(@RequestBody Student student) {
		
		studentDao.deleteStudent(student);
		return "Deleted Sucessfully";
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Student> fetchById(@PathVariable int id) {
		
		Student student = studentDao.findById(id);
		if(student != null) {
			return new ResponseEntity<Student>(student,HttpStatus.OK);
		}
		throw new IdNotFoundException("Id Not Found");
	}
//	@ExceptionHandler(IdNotFoundException.class)
//	public StudentErrorResponse handleIdNotFoundException(IdNotFoundException e) {
////	    long millis = System.currentTimeMillis();
////	    String message = e.getMessage();
////	    Map<String, Object> errorDetails = new HashMap<>();
////	    errorDetails.put("timestamp", millis);
////	    errorDetails.put("status", 404);
////	    errorDetails.put("error", "Not Found");
////	    errorDetails.put("message", message);
//	    
//	    StudentErrorResponse error = new StudentErrorResponse();
//	    error.setMessege(e.getMessage());
//	    error.setTimestamp(System.currentTimeMillis());
//	    error.setStatus(404);
//	    
//	    return error;
//	}

	
	
	@GetMapping("/findByName/{name}")
	public ResponseEntity<List<Student>> fetchByName(@PathVariable String name) {
		List<Student> fetchByName = studentDao.fetchByName(name);
		if(!fetchByName.isEmpty()) {
			return new ResponseEntity<List<Student>>(fetchByName,HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Student>>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/findByEmailAndPassword/{email}/{password}")
	public Student fetchByEmailAndPassword(@PathVariable String email,@PathVariable String password) {
		 return studentDao.fetchByEmailAndPassword(email, password);
		 
	}
	
	
	@PutMapping("/updateById/{id}/{studentDao}")
	public Student updateByEmailAndPassword(@PathVariable int id,@PathVariable Student stu) {
		return 	studentDao.updateById(id, stu);
	
	}
}

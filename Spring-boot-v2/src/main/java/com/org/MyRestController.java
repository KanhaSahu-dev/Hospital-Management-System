package com.org;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //@ResponseBody + @Controller
public class MyRestController {
	@GetMapping("/msg")
	public String msg() {
		return "Hello! Spring Boot";
	}
	
	
	@GetMapping("/fetchStudent")
	public Student fetchStudent() {
		
		Student std = new Student();
		
		std.setId(1);
		std.setName("Kanha");
		std.setAge(22);
		std.setEmail("kanhasahu273273@gmail.com");
		std.setPassword("abcd");
		std.setGender("Male");
		
		return std;
		
	}
	@GetMapping("/fetchAll")
	public List<Student> fetchAllStudent(){
		List<Student> list = new ArrayList<Student>();
		
		list.add(new Student(1,"a",20,"k@gmail.com","123","M"));
		list.add(new Student(2,"b",10,"a@gmail.com","456","F"));
		list.add(new Student(3,"c",40,"b@gmail.com","567","M"));
		list.add(new Student(4,"d",89,"g@gmail.com","543","M"));
		list.add(new Student(5,"e",45,"g@gmail.com","456","F"));
		return  list;
	}
	
	@PostMapping("/student")
	public String saveStudent(@RequestBody Student std) {
		System.out.println(std);
		return "Successfully done";
	}
	@GetMapping("/fetchById")
	public String fetchById(@RequestParam int id) {
		System.out.println(id);
		return "Successfully done";
	}
	
	
	
}

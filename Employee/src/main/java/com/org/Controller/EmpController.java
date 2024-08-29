package com.org.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmpController {
	static List<Employee> list = new ArrayList<Employee>();
	static {
		list.add(new Employee(1, "Kanha", "Assosiate"));
		list.add(new Employee(2, "A", "java"));
		list.add(new Employee(3, "B", "Python"));
		list.add(new Employee(4, "C", "Python"));
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@RequestBody Employee e) {
		list.add(e);
		return "Successfully saved";
	}
	
	
	@GetMapping("/fetchById")
	public Employee fetchById(@RequestParam int id) {
		Employee emp = list.get(id);
		return emp;
	}
	
	
	@GetMapping("/fetchAll")
	public List<Employee> fetchAll(){	
		return list;
	}
	
	@PostMapping("/deleteById")
	public String deleteById(@RequestParam int id) {
		list.remove(id-1);
		return "Deleted Successfully";
	}
	
	@PostMapping("/updateById")
	public String updateById(@RequestParam int id,@RequestBody Employee emp) {
		
		list.set(id-1, emp);
		
		return "Updated Succesfully";
	}
}

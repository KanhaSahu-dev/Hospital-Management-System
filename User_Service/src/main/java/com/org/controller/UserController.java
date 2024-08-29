package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.dao.User_dao;
import com.org.dto.User;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	User_dao userDao;
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<User>(userDao.saveUser(user),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> fetchById(@PathVariable Integer id) {
		User user = userDao.fetchById(id);
		if(user!=null)
			return new ResponseEntity<User>(user,HttpStatus.OK);
		else
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> fetchAllUsers(){
		List<User> fetchAllUsers = userDao.fetchAllUsers();
		if(fetchAllUsers!=null)
			return new ResponseEntity<List<User>>(fetchAllUsers,HttpStatus.OK);
		else
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeById(@PathVariable Integer id){
		String removeById = userDao.removeById(id);
		return new ResponseEntity<String>(removeById,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable Integer id,@RequestBody User user){
		userDao.updateUserById(id, user);
		return new ResponseEntity<String>("Updated successfully",HttpStatus.OK);
	}
}

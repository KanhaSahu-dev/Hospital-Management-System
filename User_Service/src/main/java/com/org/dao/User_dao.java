package com.org.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.dto.User;
import com.org.repository.UserRepository;

@Repository
public class User_dao {
	@Autowired
	UserRepository repo;
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	public User fetchById(int id) {
		return repo.findById(id).orElse(null);		
	}
	
	public List<User> fetchAllUsers(){
		return repo.findAll();
	}
	
	public String removeById(int id) {
		repo.deleteById(id);
		
		return "User removed";
	}
	
	public User updateUserById(int id , User user) {
		if(repo.findById(id)!=null) {
			repo.save(user);
			return repo.findById(id).orElse(null);
		}
		return null;
	}
}

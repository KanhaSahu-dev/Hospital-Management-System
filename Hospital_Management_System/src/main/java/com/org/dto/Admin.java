package com.org.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String email;

	private String password;

	public Admin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

}

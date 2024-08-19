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
public class Specialist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;

	public Specialist(String name) {
		super();
		this.name = name;
	}

	public Specialist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

package com.org.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private int age;
	
	private String gender;
	
	private String email;
	
	private String diseases;
	
	private String AppointmentDate;
	
	private long phone;
	
	private String address;
	
	private String status = "pending";
	
	private long aadhar;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Doctor doctor;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private User user;
	
}

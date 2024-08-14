package com.org;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class Student {
	@Autowired
	@Qualifier("lamborigini")
	Car car;
	
	{
		System.out.println("Student Object Created");
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}

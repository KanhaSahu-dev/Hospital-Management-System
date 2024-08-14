package com.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MoFirstSpringBootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MoFirstSpringBootApplication.class, args);
		Student std = context.getBean(Student.class);
		
		System.out.println(std.getCar());
	}

}

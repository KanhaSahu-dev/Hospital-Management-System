package com.org.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.org.dto.Student;

@Controller
public class MyController {
	
	@GetMapping("/test")
	public ModelAndView msg() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("name","Kanha");
		mav.addObject("date",new Date());
		return mav;
	}
	
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(1,"Kanha","K@gmail.com","123"));
		list.add(new Student(2,"A","A@gmail.com","123"));
		list.add(new Student(3,"B","B@gmail.com","123"));
		list.add(new Student(4,"C","C@gmail.com","123"));
		list.add(new Student(5,"D","D@gmail.com","123"));
		
		mav.addObject("students",list);
		
		return mav;
	}
	
	@GetMapping("/dummy")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("form");
		
		mav.addObject("student",new Student(2,"A","A@gmail.com","123"));
		
		return mav;
	}
}

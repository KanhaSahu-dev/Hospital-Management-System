package com.org.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.AdminDao;
import com.org.dao.DoctorDao;
import com.org.dto.Admin;
import com.org.dto.Doctor;

@Controller
public class AdminController {

	@Autowired
	private AdminDao adminDao;

	@PostMapping("/admin_register")
	public ModelAndView admin_register(@ModelAttribute Admin admin) {
		ModelAndView mav = new ModelAndView("admin_register.jsp");
		adminDao.insertAndUpdateAdmin(admin);
		mav.addObject("success", "Registered Succefully");
		return mav;
	}
	
	@PostMapping("/admin_login")
	public ModelAndView adminLogin
		(@RequestParam("email") String email,@RequestParam("password") String pwd) {
		
		List<Admin> list = adminDao.verifyAdminByEmailAndPassword(email, pwd);
		if(list.isEmpty())
		{
			ModelAndView mav = new ModelAndView("admin_login.jsp");
			mav.addObject("failed", "Invalid Email or Password");
			return mav;
		}
		ModelAndView mav = new ModelAndView("admin/admin_home.jsp");
		
		return mav;
	}
	
	@GetMapping("/temp_home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("admin/admin_home.jsp");
		return mav;
	}
	
	@GetMapping("/fetchAllDoctors")
	public ModelAndView fetchAll() {
		ModelAndView mav = new ModelAndView("admin/fetchAllDoctors.jsp");
		return mav;
	}
	
	@GetMapping("/temp_logout")
	public ModelAndView logout() {
		ModelAndView mav = new ModelAndView("admin_login.jsp");
		return mav;
	}
	
	@GetMapping("/patient")
	public ModelAndView patient() {
		ModelAndView mav = new ModelAndView("admin/patient.jsp");
		return mav;
	}
	
	
	
}
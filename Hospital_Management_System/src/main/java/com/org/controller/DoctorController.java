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

import com.org.dao.DoctorDao;
import com.org.dao.SpecialistDao;
import com.org.dto.Doctor;
import com.org.dto.Specialist;
import com.org.dto.Doctor;

@Controller
public class DoctorController {
	
	@Autowired
	private SpecialistDao specialistDao;
	
	@Autowired
	private DoctorDao doctorDao;
	
	
	@PostMapping("/doctor_login")
	public ModelAndView doctorLogin(HttpSession session,@RequestParam("email") String email, @RequestParam("password") String pwd) {

		List<Doctor> list = doctorDao.verifyDoctorByEmailAndPassword(email, pwd);
		if (list.isEmpty()) {
			ModelAndView mav = new ModelAndView("doctor_login.jsp");
			mav.addObject("failed", "Invalid Email or Password");
			return mav;
		}
		ModelAndView mav = new ModelAndView("doctor/doctor_home.jsp");
		session.setAttribute("doctorId",list.get(0).getId());
		

		return mav;
	}
	
	@GetMapping("/temp_doctor")
	public ModelAndView tempDoctor() {
		ModelAndView mav = new ModelAndView("doctor/addAndUpdateDoctor.jsp");
		Doctor d = new Doctor();
		mav.addObject("doctor", d);
		
		List<Specialist> listOfSpecialists = specialistDao.fetchAll();
		mav.addObject("list",listOfSpecialists);
		
		return mav;
	}
	
	@GetMapping("/temp_home_doctor")
	public ModelAndView tempDoctorHome() {
		ModelAndView mav = new ModelAndView("doctor/doctor_home.jsp");
		
		
		return mav;
	}
	
	@GetMapping("/temp_doctor_logout")
	public ModelAndView tempDoctorLogout() {
		ModelAndView mav = new ModelAndView("doctor_login.jsp");
		
		
		return mav;
	}
	
	
	@PostMapping("/registerAndUpdateDoctor")
	public ModelAndView registerAndUpdateDoctor(@ModelAttribute Doctor doctor) {
		doctorDao.insertAndUpdateDoctor(doctor);
		ModelAndView mav = new ModelAndView("admin/admin_home.jsp");
		mav.addObject("success", "Done!");
		return mav;
	}


}

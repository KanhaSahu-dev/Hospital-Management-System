package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.SpecialistDao;
import com.org.dto.Specialist;

@Controller
public class SpecialistController {
	@Autowired
	private SpecialistDao specialistDao;

	@PostMapping("/add_specialist")
	public ModelAndView addDoctor(@ModelAttribute Specialist specialist) {
		ModelAndView mav = new ModelAndView("doctor/add_specialist.jsp");
		specialistDao.insertAndUpdateSpecialist(specialist);
		mav.addObject("success", "Succesfully Added");

		return mav;
	}
	
	@GetMapping("/temp_specialist")
	public ModelAndView addSpecitalist() {
		ModelAndView mav = new ModelAndView("doctor/add_specialist.jsp");
		return mav;
	}
}

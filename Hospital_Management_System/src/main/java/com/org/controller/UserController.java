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

import com.org.dao.UserDao;
import com.org.dto.Admin;
import com.org.dto.Appointment;
import com.org.dto.User;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@PostMapping("/user_register")
	public ModelAndView user_register(@ModelAttribute User user) {
		ModelAndView mav = new ModelAndView("user_signup.jsp");
		userDao.insertAndUpdateUser(user);
		mav.addObject("success", "Registered Succefully");
		return mav;
	}
	
	
	@GetMapping("/temp_user_home")
	public ModelAndView user_home() {
		ModelAndView mav = new ModelAndView("user/user_home.jsp");
		return mav;
	}
	
	@GetMapping("/temp_user_logout")
	public ModelAndView user_logout() {
		ModelAndView mav = new ModelAndView("user_login.jsp");
		
		return mav;
	}

	
	@PostMapping("/user_login")
	public ModelAndView userLogin(HttpSession session,@RequestParam("email") String email, @RequestParam("password") String pwd) {

		List<User> list = userDao.verifyUserByEmailAndPassword(email, pwd);
		if (list.isEmpty()) {
			ModelAndView mav = new ModelAndView("user_login.jsp");
			mav.addObject("failed", "Invalid Email or Password");
			return mav;
		}
		ModelAndView mav = new ModelAndView("user/user_home.jsp");
		session.setAttribute("userId",list.get(0).getId());
		

		return mav;
	}

}

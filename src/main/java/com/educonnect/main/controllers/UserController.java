package com.educonnect.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.educonnect.main.entities.User;
import com.educonnect.main.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping({ "/", "/index" })
	public String openIndexPage() {
		return "index";
	}

	// register starts---------------------------------
	@GetMapping("/register")
	public String openRegisterPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/regForm")
	public String handleRegForm(@ModelAttribute("user") User user, Model model) {
		boolean status = userService.registerUserService(user);
		if (status) {
			model.addAttribute("successMsg", "Registered Successfully");
			// return "redirect:/register";
			return "register";
		} else {
			model.addAttribute("errorMsg", "Registration Failed");
			return "error";
		}
	}

	// register finished---------------------------------
	// login starts---------------------------------
	@GetMapping("/login")
	public String openLoginPage(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@PostMapping("/loginForm")
	public String handleLoginForm(@ModelAttribute("user") User user, Model model) {
		boolean isAuthenticated = userService.loginUserService(user.getEmail(), user.getPassword());
		if (isAuthenticated) {
			return "user-profile";
		} else {
			model.addAttribute("errorMsg", "Incorrect Email id or Password");
			return "login";
		}
	}
	// login finished---------------------------------

	@GetMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "login";
	}
}

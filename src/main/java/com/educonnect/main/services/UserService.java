package com.educonnect.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educonnect.main.entities.User;
import com.educonnect.main.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public boolean registerUserService(User user) {
		try {
			userRepository.save(user);
			System.out.println(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean loginUserService(String email, String password) {
		User user = userRepository.findByEmail(email);
		if (user != null) {
			return password.equals(user.getPassword());
		}
		return false;
	}
}

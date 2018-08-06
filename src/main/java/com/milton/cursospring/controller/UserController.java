package com.milton.cursospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.milton.cursospring.entity.User;
import com.milton.cursospring.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/user")
	public String getUsers(Model model) {
		
		List<User> findAll = userRepository.findAll();
		model.addAttribute("usersList", findAll);
		
		return "user";
		
	}

}

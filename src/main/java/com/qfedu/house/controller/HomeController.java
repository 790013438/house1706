package com.qfedu.house.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.qfedu.house.domain.User;
import com.qfedu.house.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public String toIndex() {
		return "index";
	}

	@GetMapping("/hello")
	public String foo(User user, Model model) {
		System.out.println(user);
		System.out.println(userService.login(user));
		model.addAttribute("name", "Âæê»");
		List<String> fruitList = Arrays.asList("Æ»¹û", "â¨ºïÌÒ", "»ðÁú¹û");
		model.addAttribute("fruits", fruitList);
		return "home";
	}
}

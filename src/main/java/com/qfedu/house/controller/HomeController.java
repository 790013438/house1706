package com.qfedu.house.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping({ "/", "/home" })
	public String toIndex() {
		
		return "index";
	}
	
	@GetMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
	
	@GetMapping("/toReg")
	public String toReg() {
		return "register";
	}
}

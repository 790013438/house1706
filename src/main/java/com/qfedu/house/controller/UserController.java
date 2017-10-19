package com.qfedu.house.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.qfedu.house.domain.User;
import com.qfedu.house.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public String doLogin(@Valid User user, Errors errors, HttpServletRequest request,  Model model) {
		String viewName = "login";
		if (!errors.hasErrors()) {
			user.setIpAddress(request.getRemoteAddr());
			if (userService.login(user)) {
				request.getSession().setAttribute("user", user);
				viewName = "redirect: home";
			} else {
				model.addAttribute("hint", "�û������������");
			}
		} else {
			model.addAttribute("hint", "��������Ч�ĵ�¼��Ϣ");
		}
		return viewName;
	}
	
	@PostMapping("/reg")
	public String doReg(User user, Model model) {
		String viewName = "register";
		if (userService.register(user)) {
			viewName = "redirect: toLogin";
		} else {
			model.addAttribute("hint", "ע��ʧ���볢�Ը���һ���û���");
		}
		return viewName;
	}
	
	@GetMapping("/logout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect: home";
	}
}

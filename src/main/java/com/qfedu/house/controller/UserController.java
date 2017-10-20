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
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.qfedu.house.domain.User;
import com.qfedu.house.dto.CheckResult;
import com.qfedu.house.dto.UserLoginDto;
import com.qfedu.house.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/check", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String checkUsername(String username) {
		boolean valid = userService.checkUnique(username);
		CheckResult result = new CheckResult(username, valid, 
					valid ? "用户名可用" : "用户名已被使用", 
					valid ? "ok.png" : "no.png");
		return JSON.toJSONString(result);
	}
//	public CheckResult checkUsername(String username) {
//		boolean valid = userService.checkUnique(username);
//		return new CheckResult(username, valid, 
//					valid ? "用户名可用" : "用户名已被使用", 
//					valid ? "ok.png" : "no.png");
//	}
	
	@PostMapping("/login")
	public String doLogin(@Valid UserLoginDto user, Errors errors, HttpServletRequest request,  Model model) {
		String viewName = "login";
		String codeFromServer = (String) request.getSession().getAttribute("code");
		if (codeFromServer.equalsIgnoreCase(user.getCode())) {
			if (!errors.hasErrors()) {
				user.setIpAddress(request.getRemoteAddr());
				if (userService.login(user)) {
					request.getSession().setAttribute("userId", user.getId());
					request.getSession().setAttribute("userRealname", user.getRealname());
					viewName = "redirect: home";
				} else {
					model.addAttribute("hint", "用户名或密码错误");
				}
			} else {
				model.addAttribute("hint", "请输入有效的登录信息");
			} 
		} else {
			model.addAttribute("hint", "请输入正确的验证码");
		}
		return viewName;
	}
	
	@PostMapping("/reg")
	public String doReg(User user, Model model) {
		String viewName = "register";
		if (userService.register(user)) {
			viewName = "redirect: toLogin";
		} else {
			model.addAttribute("hint", "注册失败请尝试更换一个用户名");
		}
		return viewName;
	}
	
	@GetMapping("/logout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect: home";
	}
}

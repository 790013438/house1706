package com.qfedu.house.controller;

import java.awt.image.BufferedImage;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfedu.house.util.CommonUtil;

@Controller
public class HomeController {
	
	private static final int CODE_LENGTH = 4;

	@GetMapping({ "/", "/home" })
	public String toIndex() {
		
		return "index";
	}
	
	@GetMapping(value = "/code", produces = "image/png")
	@ResponseBody
	public BufferedImage getCode(HttpSession session) {
		String code = CommonUtil.generateCode(CODE_LENGTH);
		session.setAttribute("code", code);
		return CommonUtil.generateCodeImage(code, 80, 30);
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

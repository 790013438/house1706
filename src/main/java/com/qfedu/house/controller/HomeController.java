package com.qfedu.house.controller;

import java.awt.image.BufferedImage;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfedu.house.domain.City;
import com.qfedu.house.domain.District;
import com.qfedu.house.domain.Province;
import com.qfedu.house.service.LocationService;
import com.qfedu.house.util.CommonUtil;

@Controller
public class HomeController {
	private static final int CODE_LENGTH = 4;
	
	@Autowired
	private LocationService locationService;

	@GetMapping({ "/", "/home" })
	public String toIndex() {
		return "index";
	}
	
	@GetMapping("/cities")
	@ResponseBody
	public List<City> getCities(Province province) {
		return locationService.listAllCitiesByProvince(province);
	}
	
	@GetMapping("/districts")
	@ResponseBody
	public List<District> getDistricts(City city) {
		return locationService.listAllDistrictsByCity(city);
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
	
	@GetMapping("toPub") 
	public String toPub() {
		return "pub";
	}
}

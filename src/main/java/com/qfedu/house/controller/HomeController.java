package com.qfedu.house.controller;

import java.awt.image.BufferedImage;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfedu.house.domain.City;
import com.qfedu.house.domain.District;
import com.qfedu.house.domain.House;
import com.qfedu.house.domain.Location;
import com.qfedu.house.domain.Province;
import com.qfedu.house.dto.PageBean;
import com.qfedu.house.service.HouseService;
import com.qfedu.house.service.LocationService;
import com.qfedu.house.util.CommonUtil;

@Controller
public class HomeController {
	private static final int CODE_LENGTH = 4;
	
	@Autowired
	private LocationService locationService;
	@Autowired
	private HouseService houseService;
	
	// test?location=104.4321-31.1234-55.5555
	@GetMapping("/test")
	public String test(Location location) {
		System.out.println(location.getLongitude());
		System.out.println(location.getLatitude());
		System.out.println(location.getAltitude());
		return "redirect: toLogin";
	}

	@GetMapping({ "/", "/home" })
	public String toIndex(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size, 
			Model model) {
		PageBean<House> pageBean = houseService.listHousesByPage(page, size);
		model.addAttribute("houseList", pageBean.getDataModel());
		model.addAttribute("currentPage", pageBean.getCurrentPage());
		model.addAttribute("totalPage", pageBean.getTotalPage());
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

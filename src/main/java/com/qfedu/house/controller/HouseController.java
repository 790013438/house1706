package com.qfedu.house.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.qfedu.house.domain.House;
import com.qfedu.house.domain.User;
import com.qfedu.house.service.HouseService;
import com.qfedu.house.util.CommonUtil;

@Controller
public class HouseController {
	
	@Autowired
	private HouseService houseService;

	@PostMapping("/addHouse")
	public String addHouse(House house, MultipartFile primaryPhoto, 
			MultipartFile[] photo, HttpServletRequest req, Model model) throws IOException {
		String viewName = "pub";
		String originalFilename = primaryPhoto.getOriginalFilename();
		if (!primaryPhoto.isEmpty()) {
			String newFilename = CommonUtil.getUniqueFilename() + 
					CommonUtil.getFilenameSuffix(originalFilename);
			String path = req.getServletContext().getRealPath("/images/upload");
			// 保存上传文件到指定的文件中
			primaryPhoto.transferTo(new File(path + "/" + newFilename));
			house.setMainPhoto(newFilename);
			// 用服务器的日期作为发布日期
			house.setPubDate(new Date());
			// 从HttpSession中获得userId
			Integer userId = (Integer) req.getSession().getAttribute("userId");
			house.setUser(new User(userId));
			if (houseService.publishNewHouse(house)) {
				viewName = "redirect: home";
			} else {
				model.addAttribute("hint", "发布失败请重新尝试");
			}
		} else {
			model.addAttribute("hint", "请为发布的房源上传图片");
		}
		return viewName;
	}
}

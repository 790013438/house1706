package com.qfedu.house.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qfedu.house.domain.User;
import com.qfedu.house.dto.UserLoginDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app.xml")
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testLogin() {
		UserLoginDto user = new UserLoginDto();
		user.setUsername("hellokitty");
		user.setPassword("1qaz2wsx");
		user.setCode("1234");
		user.setIpAddress("10.7.189.200");
		userService.login(user);
	}
	
	@Test
	public void testRegister() {
		User user = new User();
		user.setUsername("twoshits");
		user.setPassword("1qaz2wsx");
		user.setRealname("Á½¸ö±ã±ã");
		user.setTel("13500998765");
		user.setAdmin(false);
		userService.register(user);
	}
}

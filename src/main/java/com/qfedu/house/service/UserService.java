package com.qfedu.house.service;

import com.qfedu.house.domain.User;
import com.qfedu.house.dto.UserLoginDto;

public interface UserService {

	boolean login(UserLoginDto user);
	
	boolean register(User user);
	
	boolean checkUnique(String username);
}

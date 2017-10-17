package com.qfedu.house.service;

import com.qfedu.house.domain.User;

public interface UserService {

	boolean login(User user);
	
	boolean register(User user);
}

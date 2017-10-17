package com.qfedu.house.persistence;

import com.qfedu.house.domain.User;

public interface UserDao extends BaseDao<User, Integer> {
	
	User findByUsername(String username);
}

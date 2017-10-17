package com.qfedu.house.persistence.impl;

import com.qfedu.house.domain.User;
import com.qfedu.house.persistence.UserDao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl 
		extends BaseDaoAdapter<User, Integer> 
		implements UserDao {

	@Override
	public User findByUsername(String username) {
		List<User> userList = sessionFactory.getCurrentSession()
				.createQuery("from User as u where u.username=:username", User.class)
				.setParameter("username", username)
				.getResultList();
		return userList.size() == 1 ? userList.get(0) : null;
	}

}

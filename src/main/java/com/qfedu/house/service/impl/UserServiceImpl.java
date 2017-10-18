package com.qfedu.house.service.impl;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qfedu.house.domain.LoginLog;
import com.qfedu.house.domain.User;
import com.qfedu.house.persistence.LoginLogDao;
import com.qfedu.house.persistence.UserDao;
import com.qfedu.house.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private LoginLogDao loginLogDao;
	
	@Override
	public boolean login(User user) {
		boolean flag = false;
		User temp = userDao.findByUsername(user.getUsername());
		if (temp != null) {
			String md5 = DigestUtils.md5Hex(user.getPassword());
			flag = temp.getPassword().equals(md5);
			if (flag) {
				LoginLog loginLog = new LoginLog();
				loginLog.setUser(temp);
				loginLog.setIpAddress("211.135.62.90");
				loginLog.setLogDate(new Date());
				loginLogDao.save(loginLog);
			}
		}
		return flag;
	}

	@Override
	public boolean register(User user) {
		User temp = userDao.findByUsername(user.getUsername());
		if (temp == null) {
			String md5 = DigestUtils.md5Hex(user.getPassword());
			user.setPassword(md5);
			return userDao.save(user) != null;
		}
		return false;
	}

}

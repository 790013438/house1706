package com.qfedu.house.persistence.impl;

import org.springframework.stereotype.Repository;

import com.qfedu.house.domain.LoginLog;
import com.qfedu.house.persistence.LoginLogDao;

@Repository
public class LoginLogDaoImpl 
		extends BaseDaoAdapter<LoginLog, Integer> 
		implements LoginLogDao {
}

package com.qfedu.house.persistence.impl;

import org.springframework.stereotype.Repository;

import com.qfedu.house.domain.HouseType;
import com.qfedu.house.persistence.HouseTypeDao;

@Repository
public class HouseTypeDaoImpl 
		extends BaseDaoAdapter<HouseType, Integer> 
		implements HouseTypeDao {
}

package com.qfedu.house.persistence.impl;

import org.springframework.stereotype.Repository;

import com.qfedu.house.domain.House;
import com.qfedu.house.persistence.HouseDao;

@Repository
public class HouseDaoImpl 
		extends BaseDaoAdapter<House, Integer> 
		implements HouseDao {
}

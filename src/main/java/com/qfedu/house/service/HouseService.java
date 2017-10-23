package com.qfedu.house.service;

import java.util.List;

import com.qfedu.house.domain.House;
import com.qfedu.house.domain.HouseType;

public interface HouseService {
	
	boolean publishNewHouse(House house);

	List<HouseType> listAllHouseTypes();
}

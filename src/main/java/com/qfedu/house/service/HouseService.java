package com.qfedu.house.service;

import java.util.List;

import com.qfedu.house.domain.House;
import com.qfedu.house.domain.HouseType;
import com.qfedu.house.dto.PageBean;

public interface HouseService {
	
	boolean publishNewHouse(House house);

	List<HouseType> listAllHouseTypes();
	
	PageBean<House> listHousesByPage(int page, int size);
}

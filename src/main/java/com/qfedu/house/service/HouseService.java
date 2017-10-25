package com.qfedu.house.service;

import java.util.List;

import com.qfedu.house.domain.House;
import com.qfedu.house.domain.HouseType;
import com.qfedu.house.dto.PageBean;
import com.qfedu.house.dto.SearchHouseParam;

public interface HouseService {
	
	boolean publishNewHouse(House house);

	List<HouseType> listAllHouseTypes();
	
	PageBean<House> listHousesByPage(int page, int size);
	
	PageBean<House> searchHousesWithParamByPage(SearchHouseParam param, int page, int size);
}

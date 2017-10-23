package com.qfedu.house.persistence;

import java.util.List;

import com.qfedu.house.domain.City;
import com.qfedu.house.domain.Province;

public interface CityDao extends BaseDao<City, Integer> {
	
	List<City> findAllByProvince(Province province);
}

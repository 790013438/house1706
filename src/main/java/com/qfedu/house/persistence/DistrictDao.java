package com.qfedu.house.persistence;

import java.util.List;

import com.qfedu.house.domain.City;
import com.qfedu.house.domain.District;

public interface DistrictDao extends BaseDao<District, Integer> {
	
	List<District> findAllByCity(City city);
}

package com.qfedu.house.service;

import java.util.List;

import com.qfedu.house.domain.City;
import com.qfedu.house.domain.District;
import com.qfedu.house.domain.Province;

public interface LocationService {

	List<Province> listAllProvinces();
	
	List<City> listAllCitiesByProvince(Province province);
	
	List<District> listAllDistrictsByCity(City city);
}

package com.qfedu.house.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qfedu.house.domain.City;
import com.qfedu.house.domain.District;
import com.qfedu.house.domain.Province;
import com.qfedu.house.persistence.CityDao;
import com.qfedu.house.persistence.DistrictDao;
import com.qfedu.house.persistence.ProvinceDao;
import com.qfedu.house.service.LocationService;

@Service
@Transactional(readOnly = true)
public class LocationServiceImpl implements LocationService {
	@Autowired
	private ProvinceDao provinceDao;
	@Autowired
	private CityDao cityDao;
	@Autowired
	private DistrictDao districtDao;
	
	
	@Override
	public List<Province> listAllProvinces() {
		return provinceDao.findAll();
	}

	@Override
	public List<City> listAllCitiesByProvince(Province province) {
		return cityDao.findAllByProvince(province);
	}

	@Override
	public List<District> listAllDistrictsByCity(City city) {
		return districtDao.findAllByCity(city);
	}

}

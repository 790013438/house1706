package com.qfedu.house.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qfedu.house.domain.House;
import com.qfedu.house.domain.HouseType;
import com.qfedu.house.persistence.HouseDao;
import com.qfedu.house.persistence.HouseTypeDao;
import com.qfedu.house.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService {
	@Autowired
	private HouseTypeDao houseTypeDao;
	@Autowired
	private HouseDao houseDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<HouseType> listAllHouseTypes() {
		return houseTypeDao.findAll();
	}

	@Transactional
	@Override
	public boolean publishNewHouse(House house) {
		return houseDao.save(house) != null;
	}

}

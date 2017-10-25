package com.qfedu.house.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qfedu.house.domain.House;
import com.qfedu.house.domain.HouseType;
import com.qfedu.house.dto.PageBean;
import com.qfedu.house.dto.SearchHouseParam;
import com.qfedu.house.persistence.HouseDao;
import com.qfedu.house.persistence.HouseTypeDao;
import com.qfedu.house.service.HouseService;
import com.qfedu.house.util.HQLQueryBean;
import com.qfedu.house.util.QueryBean;

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

	@Transactional(readOnly = true)
	@Override
	public PageBean<House> listHousesByPage(int page, int size) {
		return houseDao.findByPage(page, size);
	}

	@Transactional(readOnly = true)
	@Override
	public PageBean<House> searchHousesWithParamByPage(SearchHouseParam param, int page, int size) {
		QueryBean queryBean = new HQLQueryBean(House.class)
				.addCondition("title like ?", "%" + param.getTitle() + "%")
				.addCondition(param.getHouseType().getId() != 0, "houseType=?", param.getHouseType())
				.addCondition("area>=?", param.getMinArea())
				.addCondition("area<=?", param.getMaxArea())
				.addCondition("price>=?", param.getMinPrice())
				.addCondition("price<=?", param.getMaxPrice())
				.addOrderBy("pubDate", false);
		return houseDao.findByQueryAndPage(queryBean, page, size);
	}

}

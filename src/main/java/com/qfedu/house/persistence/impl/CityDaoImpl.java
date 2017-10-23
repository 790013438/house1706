package com.qfedu.house.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qfedu.house.domain.City;
import com.qfedu.house.domain.Province;
import com.qfedu.house.persistence.CityDao;

@Repository
public class CityDaoImpl 
		extends BaseDaoAdapter<City, Integer> 
		implements CityDao {

	@Override
	public List<City> findAllByProvince(Province province) {
		return sessionFactory.getCurrentSession()
				.createQuery("from City as c where c.province=:province", City.class)
				.setParameter("province", province)
				.getResultList();
	}
}

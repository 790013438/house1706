package com.qfedu.house.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qfedu.house.domain.City;
import com.qfedu.house.domain.District;
import com.qfedu.house.persistence.DistrictDao;

@Repository
public class DistrictDaoImpl 
		extends BaseDaoAdapter<District, Integer> 
		implements DistrictDao {

	@Override
	public List<District> findAllByCity(City city) {
		return sessionFactory.getCurrentSession()
				.createQuery("from District as d where d.city=:city", District.class)
				.setParameter("city", city)
				.getResultList();
	}
}

package com.qfedu.house.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qfedu.house.domain.House;
import com.qfedu.house.dto.PageBean;
import com.qfedu.house.persistence.HouseDao;

@Repository
public class HouseDaoImpl 
		extends BaseDaoAdapter<House, Integer> 
		implements HouseDao {

	@Override
	public PageBean<House> findByPage(int page, int size) {
		List<House> dataModel = sessionFactory.getCurrentSession()
				.createQuery("from House as h order by h.pubDate desc", House.class)
				.setFirstResult((page - 1) * size)
				.setMaxResults(size)
				.getResultList();
		int count = sessionFactory.getCurrentSession()
				.createQuery("select count(h) from House as h", Long.class)
				.getSingleResult().intValue();
		int totalPage = (count - 1) / size + 1;
		return new PageBean<>(dataModel, totalPage, page, size);
	}
}

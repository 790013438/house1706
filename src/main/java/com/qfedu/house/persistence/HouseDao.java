package com.qfedu.house.persistence;

import com.qfedu.house.domain.House;
import com.qfedu.house.dto.PageBean;

public interface HouseDao extends BaseDao<House, Integer> {
	
	PageBean<House> findByPage(int page, int size);
}

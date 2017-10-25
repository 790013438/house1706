package com.qfedu.house.persistence;

import com.qfedu.house.domain.House;
import com.qfedu.house.dto.PageBean;
import com.qfedu.house.util.QueryBean;

public interface HouseDao extends BaseDao<House, Integer> {
	
	PageBean<House> findByPage(int page, int size);
	
	PageBean<House> findByQueryAndPage(QueryBean queryBean, int page, int size);
}

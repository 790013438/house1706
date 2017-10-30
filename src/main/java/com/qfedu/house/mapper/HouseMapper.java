package com.qfedu.house.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qfedu.house.domain.House;
import com.qfedu.house.dto.SearchHouseParam;

public interface HouseMapper {

	List<House> findBySearchParam(@Param("param") SearchHouseParam param, @Param("offset") int offset, @Param("size") int size);
	
	int countBySearchParam(SearchHouseParam param);
}

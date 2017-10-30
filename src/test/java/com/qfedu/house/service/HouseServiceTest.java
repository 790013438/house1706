package com.qfedu.house.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qfedu.house.domain.House;
import com.qfedu.house.domain.HouseType;
import com.qfedu.house.dto.PageBean;
import com.qfedu.house.dto.SearchHouseParam;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app.xml")
public class HouseServiceTest {

	@Autowired
	private HouseService houseService;
	
	@Test
	public void testSearchHousesWithParamByPage() {
		SearchHouseParam param = new SearchHouseParam();
		param.setTitle("");
		HouseType houseType = new HouseType();
		houseType.setId(0);
		param.setHouseType(houseType);
		// param.setPrice("400-3000");
		param.setArea("30-80");
		PageBean<House> pageBean = houseService.searchHousesWithParamByPage(param, 1, 10);
		System.out.println(pageBean.getDataModel());
		System.out.println(pageBean.getTotalPage());
	}
}

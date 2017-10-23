package com.qfedu.house.persistence.impl;

import org.springframework.stereotype.Repository;

import com.qfedu.house.domain.Province;
import com.qfedu.house.persistence.ProvinceDao;

@Repository
public class ProvinceDaoImpl 
		extends BaseDaoAdapter<Province, Integer> 
		implements ProvinceDao {
}

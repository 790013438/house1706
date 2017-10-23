package com.qfedu.house.persistence.impl;

import org.springframework.stereotype.Repository;

import com.qfedu.house.domain.HousePhoto;
import com.qfedu.house.persistence.HousePhotoDao;

@Repository
public class HousePhotoDaoImpl 
		extends BaseDaoAdapter<HousePhoto, Integer> 
		implements HousePhotoDao {
}

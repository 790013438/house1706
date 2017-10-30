package com.qfedu.house.dto;

import com.qfedu.house.domain.HouseType;

public class SearchHouseParam {
	private String title;
	private String price;
	private HouseType houseType;
	private String area;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPrice() {
		return price;
	}

	public Double getMinPrice() {
		return price.equals("不限") ?
				0.0 : Double.parseDouble(price.split("-")[0]);
	}
	
	public Double getMaxPrice() {
		return price.equals("不限") ?
				Double.MAX_VALUE : Double.parseDouble(price.split("-")[1]);
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public HouseType getHouseType() {
		return houseType;
	}

	public void setHouseType(HouseType houseType) {
		this.houseType = houseType;
	}
	
	public String getArea() {
		return area;
	}

	public Integer getMinArea() {
		return area.equals("不限") ? 0 : Integer.parseInt(area.split("-")[0]);
	}
	
	public Integer getMaxArea() {
		return area.equals("不限") ? 
				Integer.MAX_VALUE : Integer.parseInt(area.split("-")[1]);
	}

	public void setArea(String area) {
		this.area = area;
	}

}

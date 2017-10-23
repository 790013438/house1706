package com.qfedu.house.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_house_photo")
public class HousePhoto {
	@Id
	@Column(name = "photoid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String photoname;
	@ManyToOne
	@JoinColumn(name = "house_id")
	private House house;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhotoname() {
		return photoname;
	}

	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

}

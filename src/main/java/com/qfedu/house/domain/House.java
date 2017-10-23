package com.qfedu.house.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_house")
public class House {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "houseid")
	private Integer id;
	@Column(length = 50)
	private String title;
	@ManyToOne
	@JoinColumn(name = "house_type_id")
	private HouseType houseType;
	private Integer area;
	private Integer floor;
	private Integer totalFloor;
	private Double price;
	@ManyToOne
	@JoinColumn(name = "district_id")
	private District district;
	private String street;
	@Embedded
	private Contacter contacter;
	private String mainPhoto;
	@OneToMany(mappedBy = "house")
	private List<HousePhoto> otherPhotos;
	private Date pubDate;
	private String detail;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public HouseType getHouseType() {
		return houseType;
	}

	public void setHouseType(HouseType houseType) {
		this.houseType = houseType;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Integer getTotalFloor() {
		return totalFloor;
	}

	public void setTotalFloor(Integer totalFloor) {
		this.totalFloor = totalFloor;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Contacter getContacter() {
		return contacter;
	}

	public void setContacter(Contacter contacter) {
		this.contacter = contacter;
	}

	public String getMainPhoto() {
		return mainPhoto;
	}

	public void setMainPhoto(String mainPhoto) {
		this.mainPhoto = mainPhoto;
	}

	public List<HousePhoto> getOtherPhotos() {
		return otherPhotos;
	}

	public void setOtherPhotos(List<HousePhoto> otherPhotos) {
		this.otherPhotos = otherPhotos;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

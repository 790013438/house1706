package com.qfedu.house.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Contacter {
	@Column(name = "contacterName")
	private String name;
	@Column(name = "contacterTel")
	private String tel;
	@Column(name = "contacterQQ")
	private String qq;
	@Column(name = "contacterEmail")
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

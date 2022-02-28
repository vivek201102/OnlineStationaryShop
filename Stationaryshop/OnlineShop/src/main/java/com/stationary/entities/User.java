package com.stationary.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String cid;
	private String name;
	private String password;
	private String mobile;
	private String email;
	private String gender;
	private String lastLogin;
	private Address address;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(int id, String cid, String name, String password, String mobile, String email, String gender,
			String lastLogin, Address address) {
		super();
		this.id = id;
		this.cid = cid;
		this.name = name;
		this.password = password;
		this.mobile = mobile;
		this.email = email;
		this.gender = gender;
		this.lastLogin = lastLogin;
		this.address = address;
	}



	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCid() {
		return cid;
	}



	public void setCid(String cid) {
		this.cid = cid;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getLastLogin() {
		return lastLogin;
	}



	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", cid=" + cid + ", name=" + name + ", password=" + password + ", mobile=" + mobile
				+ ", email=" + email + ", gender=" + gender + ", lastLogin=" + lastLogin + ", address=" + address + "]";
	}
	
	
	
	
	
}

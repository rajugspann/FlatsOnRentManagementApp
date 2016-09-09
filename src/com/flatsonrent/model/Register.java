package com.flatsonrent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="register")
public class Register {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
private int id;
private String username;
private String password;
private String name;
private String phone;
private String address;
private String pincode;
private String city;
private String state;
public Register(){
	
}
public Register(String username, String password,String name, String phone, String address,
		String pincode, String city, String state) {
	super();
	this.username = username;
	this.password = password;
	this.name = name;
	this.phone = phone;
	this.address = address;
	this.pincode = pincode;
	this.city = city;
	this.state = state;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPhone() {
	return phone;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}

}

package com.chen.entity;

import java.util.Date;

public class Customer {
 private int id;
 private int storeId;
 private String firstName;
 private String lastName;
 private String email;
 private String addressId;
 private int active;
 private Date createDate;
 private  Date lastUpdate;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getStoreId() {
	return storeId;
}
public void setStoreId(int storeId) {
	this.storeId = storeId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddressId() {
	return addressId;
}
public void setAddressId(String addressId) {
	this.addressId = addressId;
}
public int getActive() {
	return active;
}
public void setActive(int active) {
	this.active = active;
}
public Date getCreateDate() {
	return createDate;
}
public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}
public Date getLastUpdate() {
	return lastUpdate;
}
public void setLastUpdate(Date lastUpdate) {
	this.lastUpdate = lastUpdate;
}
	
	

	
}

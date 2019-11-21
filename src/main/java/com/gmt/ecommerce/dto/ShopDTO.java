package com.gmt.ecommerce.dto;

import java.util.Set;

public class ShopDTO {
	
	private Long id;
	private String shopName;
	private String address;
	private String phoneNumber;
	private String contactPerson;
	private String email;
	private Set<ProductCategoryDTO> categorys;
	private Set<CustomerDTO> customers;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<ProductCategoryDTO> getCategorys() {
		return categorys;
	}
	public void setCategorys(Set<ProductCategoryDTO> categorys) {
		this.categorys = categorys;
	}
	public Set<CustomerDTO> getCustomers() {
		return customers;
	}
	public void setCustomers(Set<CustomerDTO> customers) {
		this.customers = customers;
	}
}

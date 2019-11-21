package com.gmt.ecommerce.dto;

import java.util.Set;

public class ProductDTO {
	
	private Long id;
	private String productName;
	private Double price;
	private ProductCategoryDTO category;
	private Long quantity;
	private Set<CustomerDTO> customerDTO;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public ProductCategoryDTO getCategory() {
		return category;
	}
	public void setCategory(ProductCategoryDTO category) {
		this.category = category;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Set<CustomerDTO> getCustomerDTO() {
		return customerDTO;
	}
	public void setCustomerDTO(Set<CustomerDTO> customerDTO) {
		this.customerDTO = customerDTO;
	}
}

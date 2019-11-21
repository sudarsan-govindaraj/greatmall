package com.gmt.ecommerce.dto;

import java.util.Set;

public class ProductCategoryDTO {
	
	private Long categoryId;
	private String categoryName;
	private Set<ProductDTO> products;
	
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Set<ProductDTO> getProducts() {
		return products;
	}
	public void setProducts(Set<ProductDTO> products) {
		this.products = products;
	}	
}

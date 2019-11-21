package com.gmt.ecommerce.service;

import java.util.List;

import com.gmt.ecommerce.dto.ProductCategoryDTO;
import com.gmt.ecommerce.dto.ProductDTO;
import com.gmt.ecommerce.model.Product;

public interface ProductService {

	public List<ProductCategoryDTO> getCategories();
	
	public List<ProductDTO> getProducts();
	
	public ProductDTO addProduct(ProductDTO product);
	
	public Product findProductById(Long productId);
	
	public ProductCategoryDTO findCategoryById(Long categoryId);
	
	public ProductDTO listCustomersByProductId(Long productId);
}

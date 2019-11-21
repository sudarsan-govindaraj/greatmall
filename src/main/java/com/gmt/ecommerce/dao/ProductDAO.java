package com.gmt.ecommerce.dao;

import java.util.List;

import com.gmt.ecommerce.dto.ProductCategoryDTO;
import com.gmt.ecommerce.dto.ProductDTO;
import com.gmt.ecommerce.model.Product;

public interface ProductDAO {
	
	public List<ProductCategoryDTO> getProductCategories();
	
	public List<ProductDTO> getProducts();
	
	public ProductDTO saveProduct(ProductDTO product);
	
	public Product findProductById(Long productId);
	
	public ProductCategoryDTO findCategoryById(Long categoryId);
	
	public ProductDTO listCustomersByProductId(Long productId);
	
}

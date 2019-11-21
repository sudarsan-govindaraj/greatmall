package com.gmt.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmt.ecommerce.dao.ProductDAO;
import com.gmt.ecommerce.dto.ProductCategoryDTO;
import com.gmt.ecommerce.dto.ProductDTO;
import com.gmt.ecommerce.model.Product;
import com.gmt.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<ProductCategoryDTO> getCategories() {
		return productDAO.getProductCategories();
	}

	@Override
	public List<ProductDTO> getProducts() {
		return productDAO.getProducts();
	}

	@Override
	public ProductDTO addProduct(ProductDTO product) {
		return productDAO.saveProduct(product);
	}

	@Override
	public Product findProductById(Long productId) { 
		return productDAO.findProductById(productId);
	}

	@Override
	public ProductCategoryDTO findCategoryById(Long categoryId) {
		return productDAO.findCategoryById(categoryId);
	}

	@Override
	public ProductDTO listCustomersByProductId(Long productId) {
		return productDAO.listCustomersByProductId(productId);
	}

}

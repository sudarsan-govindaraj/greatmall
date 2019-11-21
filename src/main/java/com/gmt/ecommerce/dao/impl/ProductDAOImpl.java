package com.gmt.ecommerce.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gmt.ecommerce.dao.ProductDAO;
import com.gmt.ecommerce.dto.ProductCategoryDTO;
import com.gmt.ecommerce.dto.ProductDTO;
import com.gmt.ecommerce.model.Product;
import com.gmt.ecommerce.model.ProductCategory;

@Transactional
@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
    private SessionFactory sessionFactory;

	@Transactional 
	@Override
	public List<ProductCategoryDTO> getProductCategories() {
		List<ProductCategoryDTO> categoryDTOs = new ArrayList<>();
		try(Session session = sessionFactory.openSession();){
			@SuppressWarnings("unchecked")
			List<ProductCategory> categories = session.createQuery("from ProductCategory").getResultList();
			categories.stream().forEach(category -> categoryDTOs.add(convertToProductCategoryDTO(category)));
			return categoryDTOs;
		}
		
	}

	@Override
	public List<ProductDTO> getProducts() {
		List<ProductDTO> productDTOs = new ArrayList<>();
		try(Session session = sessionFactory.openSession();){
			@SuppressWarnings("unchecked")
			List<Product> products = session.createQuery("from Product").list();
			products.stream().forEach(product -> productDTOs.add(convertProductDTO(product)));
			return productDTOs;
		}
	}


	@Override
	public ProductDTO saveProduct(ProductDTO productDTO) {
		try(Session session = sessionFactory.openSession();){
			long productId = (long) session.save(convertProduct(productDTO));
			return convertProductDTO(findByProduct(productId));
		}
		
	}
	
	private Product convertProduct(ProductDTO productDTO){
		if(productDTO != null){
			Product product = new Product();
			product.setId(productDTO.getId());
			product.setProductName(productDTO.getProductName());
			product.setPrice(productDTO.getPrice());
			product.setCategory(convertToProductCategory(productDTO.getCategory()));
			return product;
		}
		return null;
	}
	
	private ProductDTO convertProductDTO(Product product){
		if(product != null){
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setProductName(product.getProductName());
			productDTO.setPrice(product.getPrice());
			productDTO.setCategory(convertToProductCategoryDTO(product.getCategory()));
			return productDTO;
		}
		return null;
	}
	
	private Product findByProduct(Long productId){
		if(productId != null){
			try(Session session = sessionFactory.openSession();){
				return session.get(Product.class, productId);
			}
		}
		return null;
	}

	@Override
	public Product findProductById(Long productId) {
		Product product = findByProduct(productId);
		if(product == null){
			return null;
		}else {
			return product;
		}
		
	}
	
	
	private ProductCategoryDTO convertToProductCategoryDTO(ProductCategory category){
		if(category != null){
			ProductCategoryDTO productCategory = new ProductCategoryDTO();
			productCategory.setCategoryId(category.getId());
			productCategory.setCategoryName(category.getCategory());
			return productCategory;
		}
		return null;
			
	}
	
	private ProductCategory convertToProductCategory(ProductCategoryDTO categoryDTO) {
		if(categoryDTO != null){
			ProductCategory category = new ProductCategory();
			category.setId(categoryDTO.getCategoryId());
			category.setCategory(categoryDTO.getCategoryName());
			return category;
		}
		return null;
	}

	@Override
	public ProductCategoryDTO findCategoryById(Long categoryId) {
		try(Session session = sessionFactory.openSession();){
			return convertToProductCategoryDTO(session.get(ProductCategory.class, categoryId));
		}
	}

	@Override
	public ProductDTO listCustomersByProductId(Long productId) {
		return null;
	}
}

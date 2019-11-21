package com.gmt.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmt.ecommerce.dao.impl.ResponseDTO;
import com.gmt.ecommerce.dto.ProductCategoryDTO;
import com.gmt.ecommerce.dto.ProductDTO;
import com.gmt.ecommerce.service.ProductService;
import com.google.gson.Gson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/products")
@Api(value="greatmallonlinestore", description="Operations concerning to products in Online Store")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@ApiOperation(value = "View a list of available product categories")
	@GetMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getCategories(){
		List<ProductCategoryDTO> categories =  productService.getCategories();
		if(categories.isEmpty()){
			return  ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(new Gson().toJson(categories));
	}
	
	
	@ApiOperation(value = "View a list of available Products")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getProducts(){
		List<ProductDTO> products =  productService.getProducts();
		if(products.isEmpty()){
			return  ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(new Gson().toJson(products));
	}
	
	@ApiOperation(value = "View a list of available Category based Products")
	@GetMapping(value = "/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getCategoryBasedProducts(@PathVariable(required = true) @Valid Long categoryId){
		ResponseDTO responseDTO = new ResponseDTO();
		ProductCategoryDTO productCategory = productService.findCategoryById(categoryId);
		if(productCategory == null){
			responseDTO.setMessage("Product category not found");
			responseDTO.setStatus(ResponseDTO.FAILURE);
			return new ResponseEntity<>(new Gson().toJson(responseDTO), HttpStatus.NOT_FOUND);
		}else if(productCategory.getProducts().isEmpty()) {
			responseDTO.setMessage("Products not found");
			responseDTO.setStatus(ResponseDTO.FAILURE);
			return new ResponseEntity<>(new Gson().toJson(responseDTO), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new Gson().toJson(productCategory), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Add Products into the Great Mall online store")
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addProduct(@RequestBody ProductDTO product){
		product = productService.addProduct(product);
		if(product == null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new Gson().toJson(product));
	}
}

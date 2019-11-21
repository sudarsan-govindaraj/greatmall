package com.gmt.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmt.ecommerce.dao.impl.ResponseDTO;
import com.gmt.ecommerce.dto.OrderDTO;
import com.gmt.ecommerce.dto.ProductDTO;
import com.gmt.ecommerce.model.Product;
import com.gmt.ecommerce.service.OrderService;
import com.google.gson.Gson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value="orderonlinestore", description="Purchasing products for the GM Online Stores")
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@ApiOperation(value = "View all list of Customer Orders", response = List.class)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getOrders(){
		List<OrderDTO> orders = orderService.getOrders();
		if(orders.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(new Gson().toJson(orders));
	}
	
	
	@ApiOperation(value = "Place New Orders dfrom the GM Online Store")
	@PostMapping(value="/place", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> placeOrder(@RequestBody OrderDTO orderDTO){
		ResponseDTO responseDTO = new ResponseDTO();
		if(orderDTO == null){
			responseDTO.setStatus(ResponseDTO.FAILURE);
			responseDTO.setMessage("Customer is required.!");
			return new ResponseEntity<>(new Gson().toJson(responseDTO), HttpStatus.BAD_REQUEST);
		}
		if(orderDTO.getCustomer() == null){
			responseDTO.setStatus(ResponseDTO.FAILURE);
			responseDTO.setMessage("Customer is required.!");
			return new ResponseEntity<>(new Gson().toJson(responseDTO), HttpStatus.BAD_REQUEST);
		}else if(orderDTO.getCustomer().getId() == null){
			responseDTO.setStatus(ResponseDTO.FAILURE);
			responseDTO.setMessage("Customer id is required.!");
			return new ResponseEntity<>(new Gson().toJson(responseDTO), HttpStatus.BAD_REQUEST);
		}else if(orderDTO.getProducts() == null || orderDTO.getProducts().isEmpty()){
			responseDTO.setStatus(ResponseDTO.FAILURE);
			responseDTO.setMessage("Product is required.!");
			return new ResponseEntity<>(new Gson().toJson(responseDTO), HttpStatus.BAD_REQUEST);
		}
		for(ProductDTO productDTO :orderDTO.getProducts()){
			Product product = orderService.findProductById(productDTO.getId());
			if(product == null){
				responseDTO.setStatus(ResponseDTO.FAILURE);
				responseDTO.setMessage("Product not found.!");
				return new ResponseEntity<>(new Gson().toJson(responseDTO), HttpStatus.NOT_FOUND);
			}
		}
		OrderDTO order =  orderService.placeOrder(orderDTO);
		if(order == null){
			responseDTO.setStatus(ResponseDTO.FAILURE);
			responseDTO.setMessage("Order not created");
			return new ResponseEntity<>(new Gson().toJson(responseDTO), HttpStatus.NO_CONTENT);
		}
			
		return ResponseEntity.ok(new Gson().toJson(order));
	}
}

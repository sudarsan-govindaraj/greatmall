package com.gmt.ecommerce.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmt.ecommerce.dao.CustomerDAO;
import com.gmt.ecommerce.dao.impl.ResponseDTO;
import com.gmt.ecommerce.dto.CustomerDTO;
import com.gmt.ecommerce.util.JsonUtil;
import com.google.gson.Gson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="customersonlinestore", description="Operating Customer's related Activities")
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@ApiOperation(value = "View All Customers in Online Store")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getCustomers(){
		List<CustomerDTO> customers = customerDAO.getCustomers();
		if(customers.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(JsonUtil.getjson(customers));
	}
	
	@ApiOperation(value = "View Customer Order's Detail")
	@GetMapping(value = "/{customerId}/orders", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getCustomerOrders(@PathVariable(required = true) @Valid Long customerId){
		ResponseDTO responseDTO = new ResponseDTO();
		CustomerDTO customer = customerDAO.findCustomerOrdersByCustomerId(customerId);
		if(customer == null)
		{
			responseDTO.setStatus(ResponseDTO.FAILURE);
			responseDTO.setMessage("Customer not found.!!");
			return  new ResponseEntity<>(new Gson().toJson(responseDTO), HttpStatus.NOT_FOUND);
		}else if(customer.getOrders() == null || customer.getOrders().isEmpty()){
			responseDTO.setStatus(ResponseDTO.FAILURE);
			responseDTO.setMessage("Customer Order's not found.!!");
			return  new ResponseEntity<>(new Gson().toJson(responseDTO), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new Gson().toJson(customer), HttpStatus.OK);
	}
	
	@ApiOperation(value = "View Ordered Customer's")
	@GetMapping(value= "/order/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getOrderCustomers(){
		ResponseDTO responseDTO = new ResponseDTO();
		Set<CustomerDTO> customers = customerDAO.getOrderedCustomers();
		if(customers.isEmpty()){
			responseDTO.setStatus(ResponseDTO.FAILURE);
			responseDTO.setMessage("Ordered Customers not found.!!");
			return  new ResponseEntity<>(new Gson().toJson(responseDTO), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new Gson().toJson(customers), HttpStatus.OK);
	}

}

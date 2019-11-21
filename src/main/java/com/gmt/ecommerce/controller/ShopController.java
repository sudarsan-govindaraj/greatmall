package com.gmt.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmt.ecommerce.dao.impl.ResponseDTO;
import com.gmt.ecommerce.dto.ShopDTO;
import com.gmt.ecommerce.service.ShopService;
import com.google.gson.Gson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/shops")
@Api(value = "greatmallonlinestore", description = "Operations concerning to Shops in Online Store")
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	@ApiOperation(value = "View a list of available Shops")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getShops(){
		ResponseDTO responseDTO = new ResponseDTO();
		List<ShopDTO> shops = shopService.getShops();
		if(shops.isEmpty()){
			responseDTO.setStatus(ResponseDTO.FAILURE);
			responseDTO.setMessage("Shop's are not available.!!");
			return  new ResponseEntity<>(new Gson().toJson(responseDTO), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(new Gson().toJson(shops), HttpStatus.OK);
	}
	
	@ApiOperation(value = "View all Customer's for the Shop")
	@GetMapping(value = "/{shopId}/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getShopBasedCustomers(@PathVariable(required = true) @Valid Long shopId){
		ResponseDTO responseDTO = new ResponseDTO();
		ShopDTO shop = shopService.getShopBasedCustomers(shopId);
		if(shop == null){
			responseDTO.setStatus(ResponseDTO.FAILURE);
			responseDTO.setMessage("Shop not found");
			return  new ResponseEntity<>(new Gson().toJson(responseDTO), HttpStatus.NOT_FOUND);
		}else if(shop.getCustomers() == null || shop.getCustomers().isEmpty()){
			responseDTO.setStatus(ResponseDTO.FAILURE);
			responseDTO.setMessage("Customer's not found for this shop.!!");
			return  new ResponseEntity<>(new Gson().toJson(responseDTO), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new Gson().toJson(shop.getCustomers()), HttpStatus.OK);
	}

}

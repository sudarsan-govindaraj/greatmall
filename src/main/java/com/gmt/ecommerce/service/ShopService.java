package com.gmt.ecommerce.service;

import java.util.List;

import com.gmt.ecommerce.dto.ShopDTO;
import com.gmt.ecommerce.model.Shop;

public interface ShopService {
	
	public List<ShopDTO> getShops();
	
	public ShopDTO findShopById(Long shopId);
	
	public ShopDTO getShopBasedCustomers(Long shopId);
	
	public Shop findByShopId(Long shopId);
	
}

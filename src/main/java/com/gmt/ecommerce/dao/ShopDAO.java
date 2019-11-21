package com.gmt.ecommerce.dao;

import java.util.List;

import com.gmt.ecommerce.dto.ShopDTO;
import com.gmt.ecommerce.model.Shop;

public interface ShopDAO {

	public List<ShopDTO> listShop();
	
	public ShopDTO findShopById(Long shopId);
	
	public ShopDTO getShopBasedCustomers(Long shopId);
	
	public Shop findByShopId(Long shopId);

}

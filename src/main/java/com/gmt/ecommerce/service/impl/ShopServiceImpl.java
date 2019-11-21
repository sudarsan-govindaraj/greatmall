package com.gmt.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmt.ecommerce.dao.ShopDAO;
import com.gmt.ecommerce.dto.ShopDTO;
import com.gmt.ecommerce.model.Shop;
import com.gmt.ecommerce.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopDAO shopDAO;

	@Override
	public List<ShopDTO> getShops() {
		return shopDAO.listShop();
	}

	@Override
	public ShopDTO findShopById(Long shopId) {
		return shopDAO.findShopById(shopId);
	}

	@Override
	public ShopDTO getShopBasedCustomers(Long shopId) {
		return shopDAO.getShopBasedCustomers(shopId);
	}

	@Override
	public Shop findByShopId(Long shopId) {
		return shopDAO.findByShopId(shopId);
	}

}

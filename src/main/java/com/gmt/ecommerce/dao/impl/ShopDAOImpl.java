package com.gmt.ecommerce.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmt.ecommerce.dao.ShopDAO;
import com.gmt.ecommerce.dto.CustomerDTO;
import com.gmt.ecommerce.dto.ShopDTO;
import com.gmt.ecommerce.model.Order;
import com.gmt.ecommerce.model.Shop;

@Repository
public class ShopDAOImpl implements ShopDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ShopDTO> listShop() {
		List<ShopDTO> shopDTOs = new ArrayList<>();
		try(Session session = sessionFactory.openSession();){
			@SuppressWarnings("unchecked")
			List<Shop> shops = session.createQuery("FROM Shop").list();
			shops.forEach(shop -> shopDTOs.add(convertShopDTO(shop)));
		}
		return shopDTOs;
	}
	
	
	public ShopDTO convertShopDTO(Shop shop){
		ShopDTO shopDTO = new ShopDTO();
		shopDTO.setId(shop.getId());
		shopDTO.setShopName(shop.getShopName());
		shopDTO.setAddress(shop.getAddress());
		shopDTO.setPhoneNumber(shop.getPhoneNumber());
		shopDTO.setContactPerson(shop.getContactPerson());
		shopDTO.setEmail(shop.getEmail());
		return shopDTO;
	}

	@Override
	public ShopDTO findShopById(Long shopId) {
		try(Session session = sessionFactory.openSession();){
			Shop shop = session.get(Shop.class, shopId);
			if(shop != null)
				return this.convertShopDTO(shop);
		}
		return null;
	}


	@Override
	public ShopDTO getShopBasedCustomers(Long shopId) {
		HashSet<CustomerDTO> customerDTOs = new HashSet<>();
		ShopDTO shopDTO = new ShopDTO();
		try(Session session = sessionFactory.openSession();){
			Shop shop = session.get(Shop.class, shopId);
			if(shop != null){
				shopDTO.setId(shop.getId());
				shopDTO.setShopName(shop.getShopName());
				shopDTO.setAddress(shop.getAddress());
				shopDTO.setPhoneNumber(shop.getPhoneNumber());
				shopDTO.setContactPerson(shop.getContactPerson());
				shopDTO.setEmail(shop.getEmail());
				@SuppressWarnings("unchecked")
				List<Order> orders = session.createQuery("from Order").list();
				for(Order order : orders){
					if(order.getShop().equals(shop)){
						CustomerDTO customerDTO = new CustomerDTO();
						customerDTO.setId(order.getCustomer().getId());
						customerDTO.setFirstName(order.getCustomer().getFirstName());
						customerDTO.setLastName(order.getCustomer().getLastName());
						customerDTO.setGender(order.getCustomer().getGender());
						customerDTO.setMobileNumber(order.getCustomer().getMobileNumber());
						customerDTO.setEmail(order.getCustomer().getEmail());
						customerDTOs.add(customerDTO);
						
					}
				}
				shopDTO.setCustomers(customerDTOs);
			}
			return shopDTO;
		}
	}


	@Override
	public Shop findByShopId(Long shopId) {
		try(Session session = sessionFactory.openSession();){
			return session.get(Shop.class, shopId);
		}
	}

}

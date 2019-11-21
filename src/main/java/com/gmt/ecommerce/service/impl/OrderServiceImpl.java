package com.gmt.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmt.ecommerce.dao.OrderDAO;
import com.gmt.ecommerce.dto.OrderDTO;
import com.gmt.ecommerce.model.Product;
import com.gmt.ecommerce.service.OrderService;
import com.gmt.ecommerce.service.ProductService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDAO orderDAO; 
	
	@Autowired
	private ProductService productService; 

	@Override
	public OrderDTO placeOrder(OrderDTO orderDTO) {
		return orderDAO.placeOrder(orderDTO);
	}

	@Override
	public List<OrderDTO> getOrders() {
		return orderDAO.getOrders();
	}

	@Override
	public OrderDTO findOrderByOrderId(Long orderId) {
		return orderDAO.findOrderByOrderId(orderId);
	}

	@Override
	public Product findProductById(Long productId) {
		return productService.findProductById(productId);
	}

}

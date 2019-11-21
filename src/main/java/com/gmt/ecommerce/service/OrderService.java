package com.gmt.ecommerce.service;

import java.util.List;

import com.gmt.ecommerce.dto.OrderDTO;
import com.gmt.ecommerce.model.Product;

public interface OrderService {
	
	public OrderDTO placeOrder(OrderDTO orderDTO);
	
	public List<OrderDTO> getOrders();
	
	public OrderDTO findOrderByOrderId(Long orderId);

	public Product findProductById(Long productId);
}

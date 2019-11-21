package com.gmt.ecommerce.dao;

import java.util.List;

import com.gmt.ecommerce.dto.OrderDTO;

public interface OrderDAO {
	
	public List<OrderDTO> getOrders();
	
	public OrderDTO placeOrder(OrderDTO orderDTO);
	
	public OrderDTO findOrderByOrderId(Long orderId);

}

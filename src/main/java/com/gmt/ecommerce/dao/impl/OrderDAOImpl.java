package com.gmt.ecommerce.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmt.ecommerce.dao.OrderDAO;
import com.gmt.ecommerce.dto.OrderDTO;
import com.gmt.ecommerce.dto.ProductCategoryDTO;
import com.gmt.ecommerce.dto.ProductDTO;
import com.gmt.ecommerce.dto.ShopDTO;
import com.gmt.ecommerce.model.Order;
import com.gmt.ecommerce.model.OrderProductSummary;
import com.gmt.ecommerce.service.CustomerService;
import com.gmt.ecommerce.service.ProductService;
import com.gmt.ecommerce.service.ShopService;


@Repository
public class OrderDAOImpl implements OrderDAO {
	
	private final String CREATED = "Created";
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ShopService shopService;

	@Override
	public OrderDTO placeOrder(OrderDTO orderDTO) {
		try(Session session = sessionFactory.openSession();){
			Order order = new Order();
			order.setOrderStatus(CREATED);
			order.setCustomer(customerService.findByCustomerByCustomerId(orderDTO.getCustomer().getId()));
			order.setShop(shopService.findByShopId(orderDTO.getShop().getId()));
			long orderId = (long) session.save(order);
			this.convertToPlaceOrder(orderDTO, findOrderById(orderId));
			return converToOrderDTO(findOrderById(orderId));
		}
	}
	
	

	@Override
	public List<OrderDTO> getOrders() {
		List<OrderDTO> orderDTOs = new ArrayList<>();
		try(Session session = sessionFactory.openSession();){
			@SuppressWarnings("unchecked")
			List<Order> orders = session.createQuery("FROM Order").list();
			orders.stream().forEach(order -> orderDTOs.add(converToOrderDTO(order)));
		}
		return orderDTOs;
	}
	
	public Order findOrderById(Long orderId){
		try(Session session = sessionFactory.openSession();){
			return session.get(Order.class, orderId);
		}
	}
	
	@Override
	public OrderDTO findOrderByOrderId(Long orderId) {
		try(Session session = sessionFactory.openSession();){
			Order order = session.get(Order.class, orderId);
			if(order != null)
				return converToOrderDTO(order);
		}
		return null;
	}
	
	
	private OrderDTO converToOrderDTO(Order order){
		OrderDTO orderDTO = new OrderDTO();
		ShopDTO shopDTO = new ShopDTO();
		Set<ProductDTO> productDTOs = new HashSet<>();
		if(order != null){
			orderDTO.setOrderId(order.getId());
			orderDTO.setCreateDate(order.getCreateDate());
			orderDTO.setDeliveryDate(order.getDeliveryDate());
			orderDTO.setStatus(order.getOrderStatus());
			shopDTO.setId(order.getShop().getId());
			shopDTO.setShopName(order.getShop().getShopName());
			shopDTO.setAddress(order.getShop().getAddress());
			orderDTO.setShop(shopDTO);
			if(!order.getOrders().isEmpty()){
				for(OrderProductSummary summary : order.getOrders()){
					ProductCategoryDTO categoryDTO = new ProductCategoryDTO();
					ProductDTO productDTO = new ProductDTO();
					productDTO.setId(summary.getProduct().getId());
					productDTO.setProductName(summary.getProduct().getProductName());
					productDTO.setQuantity(summary.getProductQuantity());
					categoryDTO.setCategoryId(summary.getProduct().getCategory().getId());
					categoryDTO.setCategoryName(summary.getProduct().getCategory().getCategory());
					productDTO.setCategory(categoryDTO);
					productDTOs.add(productDTO);
				}
				orderDTO.setProducts(productDTOs);
			}
			return orderDTO;
		}
		return null;
	}
	
	private void convertToPlaceOrder(OrderDTO orderDTO, Order order){
		if(!orderDTO.getProducts().isEmpty()){
			try(Session session = sessionFactory.openSession();){
				for(ProductDTO productDTO : orderDTO.getProducts()){
					OrderProductSummary summary = new OrderProductSummary();
					summary.setProductQuantity(productDTO.getQuantity());
					summary.setProduct(productService.findProductById(productDTO.getId()));
					summary.setOrder(order);
					session.save(summary);
				}
			}
		}
	}

}

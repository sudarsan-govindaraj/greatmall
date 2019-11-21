package com.gmt.ecommerce.dto;

import java.util.Date;
import java.util.Set;

import com.gmt.ecommerce.model.OrderProductSummary;

public class OrderDTO {
	
	private Long orderId;
	private Date createDate;
	private Date deliveryDate;
	private String status;
	private OrderProductSummary orderSummary;
	private CustomerDTO customer;
	private Set<ProductDTO> products;
	private ShopDTO shop;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public OrderProductSummary getOrderSummary() {
		return orderSummary;
	}
	public void setOrderSummary(OrderProductSummary orderSummary) {
		this.orderSummary = orderSummary;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public Set<ProductDTO> getProducts() {
		return products;
	}
	public void setProducts(Set<ProductDTO> products) {
		this.products = products;
	}
	public ShopDTO getShop() {
		return shop;
	}
	public void setShop(ShopDTO shop) {
		this.shop = shop;
	}
}

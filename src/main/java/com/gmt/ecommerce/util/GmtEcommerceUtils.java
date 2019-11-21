package com.gmt.ecommerce.util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.gmt.ecommerce.dto.AddressDTO;
import com.gmt.ecommerce.dto.CustomerDTO;
import com.gmt.ecommerce.dto.OrderDTO;
import com.gmt.ecommerce.dto.ProductCategoryDTO;
import com.gmt.ecommerce.dto.ProductDTO;
import com.gmt.ecommerce.dto.ShopDTO;
import com.gmt.ecommerce.model.Address;
import com.gmt.ecommerce.model.Customer;
import com.gmt.ecommerce.model.Order;
import com.gmt.ecommerce.model.OrderProductSummary;
import com.gmt.ecommerce.model.ProductCategory;

@Component
public class GmtEcommerceUtils {
	
	public CustomerDTO convertToCustomerDTO(Customer customer){
		CustomerDTO customerDTO = new CustomerDTO();
		if(customer != null){
			customerDTO.setId(customer.getId());
			customerDTO.setFirstName(customer.getFirstName());
			customerDTO.setLastName(customer.getLastName());
			customerDTO.setGender(customer.getGender());
			customerDTO.setEmail(customer.getEmail());
			customerDTO.setMobileNumber(customer.getMobileNumber());
			customerDTO.setAlternateNumber(customer.getAlternateNumber());
			return customerDTO;
		}
		return null;
	}
	
	public CustomerDTO convertToCustomerDTOWithAddressDTO(Customer customer){
		Set<AddressDTO> addressDTOs = new HashSet<>();
		CustomerDTO customerDTO = new CustomerDTO();
		if(customer != null){
			customerDTO.setId(customer.getId());
			customerDTO.setFirstName(customer.getFirstName());
			customerDTO.setLastName(customer.getLastName());
			customerDTO.setGender(customer.getGender());
			customerDTO.setEmail(customer.getEmail());
			customerDTO.setMobileNumber(customer.getMobileNumber());
			customerDTO.setAlternateNumber(customer.getAlternateNumber());
			if(!customer.getDeliveryAddresses().isEmpty()){
				customer.getDeliveryAddresses().stream().forEach(address -> addressDTOs.add(convertToAddressDTO(address)));
				customerDTO.setAddress(addressDTOs);
			}
			return customerDTO;
		}
		return null;
	}
	
	private AddressDTO convertToAddressDTO(Address address){
		AddressDTO addressDTO = new AddressDTO();
		if(address != null){
			addressDTO.setId(address.getId());
			addressDTO.setAddressDetails(address.getAddressDetails());
			addressDTO.setCity(address.getCity());
			addressDTO.setState(address.getState());
			addressDTO.setCountry(address.getCountry());
			addressDTO.setPincode(address.getPincode());
			addressDTO.setLandmark(address.getLandmark());
			addressDTO.setAddressType(address.getAddressType());
			return addressDTO;
		}
		return null;
	}
	
	
	public CustomerDTO convertToCustomerDTOWithOrdersDetails(Customer customer){
		Set<AddressDTO> addressDTOs = new HashSet<>();
		Set<OrderDTO> orderDTOs = new HashSet<>();
		CustomerDTO customerDTO = new CustomerDTO();
		if(customer != null){
			customerDTO.setId(customer.getId());
			customerDTO.setFirstName(customer.getFirstName());
			customerDTO.setLastName(customer.getLastName());
			customerDTO.setGender(customer.getGender());
			customerDTO.setEmail(customer.getEmail());
			customerDTO.setMobileNumber(customer.getMobileNumber());
			customerDTO.setAlternateNumber(customer.getAlternateNumber());
			if(!customer.getDeliveryAddresses().isEmpty()){
				customer.getDeliveryAddresses().stream().forEach(address -> addressDTOs.add(convertToAddressDTO(address)));
				customerDTO.setAddress(addressDTOs);
			}
			if(!customer.getOrders().isEmpty()){
				customer.getOrders().stream().forEach(order -> orderDTOs.add(convertToOrderDTO(order)));
				customerDTO.setOrders(orderDTOs);
			}
			return customerDTO;
		}
		return null;
	}
	
	
	public OrderDTO convertToOrderDTO(Order order){
		ShopDTO shopDTO = new ShopDTO();
		Set<ProductDTO> productDTOs = new HashSet<>();
		OrderDTO orderDTO = new OrderDTO();
		if(order != null){
			orderDTO.setOrderId(order.getId());
			orderDTO.setDeliveryDate(order.getDeliveryDate());
			orderDTO.setCreateDate(order.getCreateDate());
			orderDTO.setStatus(order.getOrderStatus());
			order.getOrders().forEach(summary -> productDTOs.add(convertToProductDTO(summary)));
			shopDTO.setId(order.getShop().getId());
			shopDTO.setShopName(order.getShop().getShopName());
			shopDTO.setAddress(order.getShop().getAddress());
			orderDTO.setShop(shopDTO);
			orderDTO.setProducts(productDTOs);
			return orderDTO;
		}
		return null;
	}
	
	public ProductDTO convertToProductDTO(OrderProductSummary productSummary){
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(productSummary.getProduct().getId());
		productDTO.setProductName(productSummary.getProduct().getProductName());
		productDTO.setCategory(convertToProductCategoryDTO(productSummary.getProduct().getCategory()));
		productDTO.setQuantity(productSummary.getProductQuantity());
		return productDTO;
	}
	
	public ProductCategoryDTO convertToProductCategoryDTO(ProductCategory category){
		ProductCategoryDTO categoryDTO = new ProductCategoryDTO();
		categoryDTO.setCategoryId(category.getId());
		categoryDTO.setCategoryName(category.getCategory());
		return categoryDTO;
	}
	

}

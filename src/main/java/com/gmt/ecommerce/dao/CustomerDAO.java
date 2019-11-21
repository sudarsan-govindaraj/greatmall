package com.gmt.ecommerce.dao;

import java.util.List;
import java.util.Set;

import com.gmt.ecommerce.dto.CustomerDTO;
import com.gmt.ecommerce.model.Customer;

public interface CustomerDAO {
	
	public List<CustomerDTO> getCustomers();
	
	public CustomerDTO findCustomerById(Long customerId);
	
	public CustomerDTO findCustomerOrdersByCustomerId(Long customerId);
	
	public Customer findByCustomerByCustomerId(Long customerId);
	
	public Set<CustomerDTO> getOrderedCustomers();

}

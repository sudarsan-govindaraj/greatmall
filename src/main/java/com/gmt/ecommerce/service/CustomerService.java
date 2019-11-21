package com.gmt.ecommerce.service;

import java.util.List;
import java.util.Set;

import com.gmt.ecommerce.dto.CustomerDTO;
import com.gmt.ecommerce.model.Customer;

public interface CustomerService {
	
	public List<CustomerDTO> getCustomers();
	
	public CustomerDTO findCustomerById(Long customerId);
	
	public Customer findByCustomerByCustomerId(Long customerId);
	
	public Set<CustomerDTO> getOrderedCustomers();

}

package com.gmt.ecommerce.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmt.ecommerce.dao.CustomerDAO;
import com.gmt.ecommerce.dto.CustomerDTO;
import com.gmt.ecommerce.model.Customer;
import com.gmt.ecommerce.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public List<CustomerDTO> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	public CustomerDTO findCustomerById(Long customerId) {
		return customerDAO.findCustomerById(customerId);
	}

	@Override
	public Customer findByCustomerByCustomerId(Long customerId) {
		return customerDAO.findByCustomerByCustomerId(customerId);
	}

	@Override
	public Set<CustomerDTO> getOrderedCustomers() {
		return customerDAO.getOrderedCustomers();
	}

}

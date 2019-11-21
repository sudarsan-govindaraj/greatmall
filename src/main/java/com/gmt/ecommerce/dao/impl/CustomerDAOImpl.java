package com.gmt.ecommerce.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmt.ecommerce.dao.CustomerDAO;
import com.gmt.ecommerce.dto.CustomerDTO;
import com.gmt.ecommerce.model.Customer;
import com.gmt.ecommerce.model.Order;
import com.gmt.ecommerce.util.GmtEcommerceUtils;


@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Autowired
	private GmtEcommerceUtils gmtEcommerceUtils;

	@Override
	public List<CustomerDTO> getCustomers() {
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		try(Session session = this.sessionFactory.openSession();){
			@SuppressWarnings("unchecked")
			List<Customer> customerList = session.createQuery("from Customer").list();
			customerList.stream().forEach(customer -> customerDTOs.add(gmtEcommerceUtils.convertToCustomerDTOWithAddressDTO(customer)));
			return customerDTOs;
		}
	}
	

	@Override
	public CustomerDTO findCustomerById(Long customerId) {
		try(Session session = sessionFactory.openSession();){
			Customer customer = session.get(Customer.class, customerId);
			if(customer != null)
				return gmtEcommerceUtils.convertToCustomerDTO(customer);
		}
		return null;
	}


	@Override
	public CustomerDTO findCustomerOrdersByCustomerId(Long customerId) {
		try(Session session = sessionFactory.openSession();){
			Customer customer = session.get(Customer.class, customerId);
			if(customer != null)
				return gmtEcommerceUtils.convertToCustomerDTOWithOrdersDetails(customer);
		}
		return null;
	}


	@Override
	public Customer findByCustomerByCustomerId(Long customerId) {
		try(Session session = sessionFactory.openSession();){
			return session.get(Customer.class, customerId);
		}
	}


	@Override
	public Set<CustomerDTO> getOrderedCustomers() {
		HashSet<CustomerDTO> customerDTOs = new HashSet<>();
		try(Session session = sessionFactory.openSession();){
			@SuppressWarnings("unchecked")
			List<Order> orders = session.createQuery("from Order").list();
			for(Order order : orders){
				CustomerDTO customerDTO = new CustomerDTO();
				customerDTO.setId(order.getCustomer().getId());
				customerDTO.setFirstName(order.getCustomer().getFirstName());
				customerDTO.setLastName(order.getCustomer().getLastName());
				customerDTO.setGender(order.getCustomer().getGender());
				customerDTO.setMobileNumber(order.getCustomer().getMobileNumber());
				customerDTO.setEmail(order.getCustomer().getEmail());
				customerDTOs.add(customerDTO);
			}
			return customerDTOs;
		}
	}

}

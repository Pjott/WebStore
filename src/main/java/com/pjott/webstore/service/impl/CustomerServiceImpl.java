package com.pjott.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjott.webstore.domain.Customer;
import com.pjott.webstore.domain.repository.CustomerRepository;
import com.pjott.webstore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> allCustomers = customerRepository.getAllCustomers();
		return allCustomers;
	}

	
}

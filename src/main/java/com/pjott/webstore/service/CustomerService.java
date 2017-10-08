package com.pjott.webstore.service;

import java.util.List;

import com.pjott.webstore.domain.Customer;

public interface CustomerService {

	List<Customer> getAllCustomers();
	
	void addCustomer(Customer customer);
}

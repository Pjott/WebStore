package com.pjott.webstore.domain.repository;

import java.util.List;

import com.pjott.webstore.domain.Customer;

public interface CustomerRepository {

	List<Customer> getAllCustomers();
}

package com.pjott.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pjott.webstore.domain.Customer;
import com.pjott.webstore.domain.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Customer> getAllCustomers() {
		Map<String, Object> customerParams = new HashMap<String, Object>();
		List<Customer> customerResult = jdbcTemplate.query("SELECT * FROM customers", customerParams, new CustomerMapper());
		
		return customerResult;
	}

	private static final class CustomerMapper implements RowMapper<Customer> {

		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getString("ID"));
			customer.setName(rs.getString("NAME"));
			customer.setAddress(rs.getString("ADDRESS"));
			customer.setNoOfOrdersMade(rs.getInt("NOOFORDERSMADE"));
			
			return customer;
		}
	}

	@Override
	public void addCustomer(Customer customer) {
		String SQLCustomer = "INSERT INTO CUSTOMERS (ID, NAME, ADDRESS, NOOFORDERSMADE)" 
								+ "VALUES (:id, :name, :address, :noOfOrdersMade)";
		Map<String, Object> newCustomerParams = new HashMap<>();
		newCustomerParams.put("id", customer.getCustomerId());
		newCustomerParams.put("name", customer.getName());
		newCustomerParams.put("address", customer.getAddress());
		newCustomerParams.put("noOfOrdersMade", customer.getNoOfOrdersMade());
		
		jdbcTemplate.update(SQLCustomer, newCustomerParams);
	}
	
	
}

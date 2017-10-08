package com.pjott.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pjott.webstore.domain.Customer;
import com.pjott.webstore.domain.Product;
import com.pjott.webstore.service.CustomerService;

@Controller
public class CustomerContoller {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customers")
	public String customerList(Model model) {
		model.addAttribute("customers", customerService.getAllCustomers());
		
		return "customersPage";
	}
	
	@RequestMapping(value = "/customers/add", method = RequestMethod.GET)
	public String getAddNewCustomerForm(Model model) {
		Customer newCustomer = new Customer();
		model.addAttribute("newCustomer", newCustomer);
		return "addCustomerPage";
	}
	
	@RequestMapping(value = "/customers/add", method = RequestMethod.POST)
	public String processAddNewCustomerForm(@ModelAttribute("newCustomer") Customer newCustomer) {
		customerService.addCustomer(newCustomer);
		
		return "redirect:/customers/add";
	}
}

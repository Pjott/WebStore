package com.pjott.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

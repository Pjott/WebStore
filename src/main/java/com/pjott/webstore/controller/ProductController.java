package com.pjott.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pjott.webstore.domain.repository.ProductRepository;
import com.pjott.webstore.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;

	@RequestMapping("/products")
	public String list(Model model) {		
		model.addAttribute("products", productRepository.getAllProducts());
		
		return "productsPage";
	}
	
	@RequestMapping("/update/stock")
	public String updateSrock(Model model) {
		productService.updateAllStock();
		
		return "redirect:/products";
	}
}

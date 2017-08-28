package com.pjott.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pjott.webstore.domain.repository.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;

	@RequestMapping("/products")
	public String list(Model model) {
		
	/*	Product itemOne = new Product("A34C", "Bumbulator", new BigDecimal(505));
		itemOne.setDescription("Bumbulator z dodatkową przystawką i kalfasakiem");
		itemOne.setCategory("WTF");
		itemOne.setManufacturer("Odidos");
		itemOne.setUnitsInStock(20);
		model.addAttribute("product", itemOne); */
		
		model.addAttribute("products", productRepository.getAllProducts());
		
		return "productsPage";
	}
}

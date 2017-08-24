package com.pjott.webstore.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pjott.webstore.domain.Product;

@Controller
public class ProductController {

	@RequestMapping("/products")
	public String list(Model model) {
		
		Product itemOne = new Product("A34C", "Bumbulator", new BigDecimal(505));
		itemOne.setDescription("Bumbulator z dodatkową przystawką i kalfasakiem");
		itemOne.setCategory("WTF");
		itemOne.setManufacturer("Odidos");
		itemOne.setUnitsInStock(20);
		model.addAttribute("product", itemOne);
		
		return "productsPage";
	}
}

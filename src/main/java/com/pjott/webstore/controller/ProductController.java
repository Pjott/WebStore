package com.pjott.webstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pjott.webstore.service.ProductService;

@Controller
@RequestMapping("market")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping("/products")
	public String list(Model model) {		
		model.addAttribute("products", productService.getAllProducts());
		
		return "productsPage";
	}
	
	@RequestMapping("/update/stock")
	public String updateSrock(Model model) {
		productService.updateAllStock();
		
		return "redirect:/market/products";
	}
	
	@RequestMapping("/products/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
		model.addAttribute("products", productService.getProductsByCategory(productCategory));
		
		return "productsPage";
	}
	@RequestMapping("/products/filter/{params}")
	public String getProductsByFilter(Model model, @MatrixVariable(pathVar="params") Map<String, List<String>> filterParams) {
		model.addAttribute("products", productService.getProductsByFilter(filterParams));
		
		return "productsPage";
	}
	
	@RequestMapping("/product")
	public String getProductBtId(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		
		return "productPage";
	}
}

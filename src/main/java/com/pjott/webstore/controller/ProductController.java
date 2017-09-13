package com.pjott.webstore.controller;

import java.math.BigDecimal;
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
		// http://localhost:8080/webstore/market/products
		return "productsPage";
	}
	
	@RequestMapping("/update/stock")
	public String updateSrock(Model model) {
		productService.updateAllStock();
		// http://localhost:8080/webstore/market/products
		return "redirect:/market/products";
	}
	
	@RequestMapping("/products/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
		model.addAttribute("products", productService.getProductsByCategory(productCategory));
		// http://localhost:8080/webstore/market/products/WTF
		return "productsPage";
	}
	@RequestMapping("/products/filter/{params}")
	public String getProductsByFilter(Model model, @MatrixVariable(pathVar="params") Map<String, List<String>> filterParams) {
		model.addAttribute("products", productService.getProductsByFilter(filterParams));
		// http://localhost:8080/webstore/market/products/filter/params;brands=Odidos,FSS;categories=WTF,Fitting
		return "productsPage";
	}
	
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		// http://localhost:8080/webstore/market/product?id=A34C
		return "productPage";
	}
	
	@RequestMapping("/products/{category}/{price}")
	public String getFilteredProductsByPriceAndBrand(Model model
													, @PathVariable("category") String productCategory
													, @MatrixVariable(pathVar="price") Map<String, List<BigDecimal>> priceRange
													, @RequestParam("brands") String manufacturer) {
		model.addAttribute("products", productService.getProductsByCategory(productCategory));
		model.addAttribute("products", productService.getProductsByPriceRange(priceRange));
		model.addAttribute("products", productService.getProductByBrands(manufacturer));
		/*
		 * TODO
		 * @PathVariable("category") i metoda getProductsByCategory zostaje. Resztę patrz na "TODO" w InMemoryProductRepository
		 */
		return "productsPage";
	}
	// http://localhost:8080/webstore/market/products/WTF/price;low=300;high=600?brands=Odidos
}

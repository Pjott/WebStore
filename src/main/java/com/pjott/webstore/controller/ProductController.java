package com.pjott.webstore.controller;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;


import com.pjott.webstore.domain.Product;
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
	
	@RequestMapping(value = "/products/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProductPage";
	}
	
	@RequestMapping(value = "/products/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, BindingResult result, HttpServletRequest request) {
		String[] suppressedFields = result.getSuppressedFields();
		if(suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		MultipartFile productImage = newProduct.getProductImage();
		MultipartFile productManual = newProduct.getProductManual();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if(productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(rootDirectory + "resources\\images" + newProduct.getProductId() + ".png"));
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}
		
		if(productManual != null && !productManual.isEmpty()) {
			try {
				productManual.transferTo(new File(rootDirectory + "resources\\manuals" + newProduct.getProductId() + ".pdf"));
			} catch (Exception e) {
				throw new RuntimeException("Product Manual saving failed", e);
			}
		}
		
		productService.addProduct(newProduct);
		
		return "redirect:/market/products";
	}
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("productId", "name", "unitPrice", "description", "manufacturer", "category", "unitsInStock", "condition", "productImage", "productManual");
	}
}

package com.pjott.webstore.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.pjott.webstore.domain.Product;

public interface ProductRepository {

	List <Product> getAllProducts();
	
	void updateStock(String productId, long noOfUnits);
	
	List<Product> getProductsByCategory(String category);
	
	List<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	Product getProductById(String productId);
	
	// List<Product> getProductsByPriceAndBrandFilter(Map<String, List<String>> priceAndBrandFilterParams);
	
	List<Product> getProductsByPriceRange(Map<String, List<BigDecimal>> priceRange);
	
	Product getProductByBrands(String manufacturer);
}

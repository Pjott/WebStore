package com.pjott.webstore.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjott.webstore.domain.Product;
import com.pjott.webstore.domain.repository.ProductRepository;
import com.pjott.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void updateAllStock() {
		List<Product> allProducts = productRepository.getAllProducts();
		for(Product product : allProducts) {
			if(product.getUnitsInStock() < 500) {
				productRepository.updateStock(product.getProductId(), product.getUnitsInStock() + 1000);
			}
		}
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}

	@Override
	public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		return productRepository.getProductsByFilter(filterParams);
	}

	@Override
	public Product getProductById(String productId) {
		return productRepository.getProductById(productId);
	}

	@Override
	public Product getProductByBrands(String manufacturer) {
		return productRepository.getProductByBrands(manufacturer);
	}

	@Override
	public List<Product> getProductsByPriceRange(Map<String, List<BigDecimal>> priceRange) {
		return productRepository.getProductsByPriceRange(priceRange);
	}

	/*@Override
	public List<Product> getProductsByPriceAndBrandFilter(Map<String, List<String>> priceAndBrandFilterParams) {
		return productRepository.getProductsByPriceAndBrandFilter(priceAndBrandFilterParams);
	}*/
	
	
	
	
}

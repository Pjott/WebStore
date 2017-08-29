package com.pjott.webstore.service.impl;

import java.util.List;

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

}

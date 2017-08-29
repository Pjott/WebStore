package com.pjott.webstore.service;

import java.util.List;

import com.pjott.webstore.domain.Product;

public interface ProductService {

	void updateAllStock();
	
	List <Product> getAllProducts();
}

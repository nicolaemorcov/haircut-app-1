package com.commons.service;

import java.util.ArrayList;
import java.util.List;

import com.commons.entities.Product;

public class ProductService {

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		
		products.add(new Product(1, "Shampoo", 5.9, "xxxx  ", 199, "Shampoo", 4.3));
		products.add(new Product(2, "Shave balsam", 5.9, "xxxx  ", 199, "Shampoo", 4.3));
		
		return products;
	}
}

package com.commons;

import java.util.ArrayList;
import java.util.List;

import com.commons.entities.Product;

public class Cart {
	//list of type Product
	List<Product> cartItems = new ArrayList<Product>();
	
	
	private Product getProductById(int productId) {
		Product product = null;
		List<Product> products = new ProductStock().getProducts();
		for(Product prod: products) {
			if(prod.getProductId() == productId) {
				product = prod;
				break;
			}
		}
		return product;
	}
	
	//add item to card
	private void addToCart(Product product) {
		cartItems.add(product);
	}
	
	//add product to list by ID
		public void addToCartById(int id) {
			Product product = getProductById(id);
			addToCart(product);
		}
	
/*		
	//remove item from cart
	private void removeFromCart(Product product) {
		cartItems.remove(product);
	}*/
	
	//remove item from cart by ID
}

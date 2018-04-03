/**
 * 
 */
package com.commons;

import java.util.ArrayList;
import java.util.List;

import com.commons.entities.Product;

/**
 * @author Nicolae Morcov
 *
 */
public class ProductStock{
	private final List<Product> products = new ArrayList<Product>();
	private Object[] produtPrice;
	
	public ProductStock() {
		this.initStoreItems();
	}
	
	public List<Product> getProducts(){
		return products;
	}
	
	public void initStoreItems() {
		String[] productNames = {};
		Double[] productPrice = {};
		Integer[] stock = {};
		
		for(int i = 0; i < productNames.length; i++) {
			this.products.add(new Product(i + 1, productNames[i], productPrice[i], stock[i]));
		}
	}
}

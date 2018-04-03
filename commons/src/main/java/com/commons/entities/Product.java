package com.commons.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "product")
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_price")
	private double productPrice;
	@Column(name = "product_description")
	private String description;
	@Column(name = "stock")
	private int stock;
	@Column(name = "product_type")
	private String productType;
	@Column(name = "tax")
	private double tax;

	/**
	 * @param productId
	 * @param name
	 * @param price
	 * @param description
	 * @param quantity
	 * @param productType
	 * @param tax
	 */
	public Product(int productId, String name, double price, String description, int stock, String productType,
			double tax) {
		super();
		this.productId = productId;
		this.productName = name;
		this.productPrice = price;
		this.description = description;
		this.stock = stock;
		this.productType = productType;
		this.tax = tax;
		
	}
	
	



	public Product(int productId, String name, Double price, Integer stock) {
		// TODO Auto-generated constructor stub
	}



	//getters
	public int getProductId() {
		return productId;
	}
	public String getName() {
		return productName;
	}
	public double getPrice() {
		return productPrice;
	}
	public String getDescription() {
		return description;
	}
	public int getStock() {
		return stock;
	}
	public String getProductType() {
		return productType;
	}
	public double getTax() {
		return tax;
	}

	//setters
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setName(String name) {
		this.productName = name;
	}
	public void setPrice(double price) {
		this.productPrice = price;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}

	
	//add
	public void addProduct() {
		System.out.println("Add to database");
	}
	
	//remove
	public void removeProduct() {
		System.out.println("Remove from database");
	}
	
	//update
	public void updateProduct() {
		System.out.println("Update product");
	}
	
}

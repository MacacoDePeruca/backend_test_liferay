package com.liferay.vitornascimento.entities;

import java.math.BigDecimal;
import java.math.MathContext;

public class Product {

	private double price;
	private String description;
	private ProductCategory category;
	private boolean imported;
	private double shelfPrice;
	private boolean taxed; 
	

	public Product( Product billedProduct) {
		
		this.price = new BigDecimal(billedProduct.price)
				.round(new MathContext(4)).doubleValue();
		
		this.description = billedProduct.description;
		this.category = billedProduct.category;
		this.imported = billedProduct.imported;
		this.shelfPrice = new BigDecimal(billedProduct.shelfPrice)
				.round(new MathContext(4)).doubleValue();
		this.taxed = billedProduct.taxed;
		
	}
	
	
	public Product(double price, String description, ProductCategory category, boolean imported) {
		this.price = price;
		this.description = description;
		this.category = category;
		this.imported = imported;
	}
	
	
	public double getShelfPrice() {
		return shelfPrice;
	}


	public void setShelfPrice(double shelfPrice) {
		this.shelfPrice = shelfPrice;
	}


	public boolean istaxed() {
		return taxed;
	}


	public void settaxed(boolean taxed) {
		this.taxed = taxed;
	}


	public boolean isImported() {
		return imported;
	}


	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ProductCategory getCategory() {
		return category;
	}	
	
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.description+" at "+price ;
	}
	
	
	
	
}

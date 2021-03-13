package com.liferay.vitornascimento.entities;

public class Product {

	private double price;
	private String description;
	private ProductCategory category;
	private boolean imported;
	

	public Product( Product billedProduct) {
		
		this.price = billedProduct.getPrice();
		this.description = billedProduct.getDescription();
		this.category = billedProduct.getCategory();
		
	}
	
	
	public Product(double price, String description, ProductCategory category, boolean imported) {
		this.price = price;
		this.description = description;
		this.category = category;
		this.imported = imported;
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

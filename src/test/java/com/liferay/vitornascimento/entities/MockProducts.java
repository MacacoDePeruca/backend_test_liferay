package com.liferay.vitornascimento.entities;

import java.util.ArrayList;
import java.util.List;

public class MockProducts {
	
	
	
	public double randomPrice() {
		
		double numero =  ((int) ((Math.random() * 900) + 100) / 100.0);
		
		return numero;
	}
	

	public Product mockFood(Integer number) {
		
		

		return new Product(Math.random() * 100, "FOOD " + number, ProductCategory.FOOD, false);
	}

	public List<Product> mockFoodList() {

		List<Product> foodList = new ArrayList<Product>();

		for (int i = 0; i < 10; i++) {

			foodList.add(mockFood(i));
		}

		return foodList;

	}

	public Product mockBook(Integer number) {

		return new Product(Math.random() * 100, "BOOK " + number, ProductCategory.BOOK, false);
	}

	public List<Product> mockBookList() {

		List<Product> foodList = new ArrayList<Product>();

		for (int i = 0; i < 10; i++) {

			foodList.add(mockBook(i));
		}

		return foodList;

	}

	public Product mockDrug(Integer number) {

		return new Product(Math.random() * 100, "MEDICAL " + number, ProductCategory.MEDICAL, false);
	}

	public Product mockCommon(Integer number) {

		return new Product(Math.random() * 100, "Common item " + number, ProductCategory.COMMON, false);
	}
	public Product mockCommonPrice(Integer number ,Double productPrice) {
		
		return new Product(productPrice, "Common item " + number, ProductCategory.COMMON, false);
	}

	/* IMPORTED PRODUCT */
	
	public Product mockImportedCommon(Integer number) {

		return new Product(randomPrice(), "Imported Common item " + number, ProductCategory.COMMON, true);
	}
	
	public Product mockImportedBook(Integer number) {
		
		return new Product(Math.random() * 100, "Imported book " + number, ProductCategory.BOOK, true);
	}
	
	public Product mockImportedDrug(Integer number) {
		
		return new Product(Math.random() * 100, "Imported drug " + number, ProductCategory.MEDICAL, true);
	}
	
	public Product mockImportedFood(Integer number) {
		
		return new Product(Math.random() * 100, "Imported food " + number, ProductCategory.FOOD, true);
	}

	public List<Product> mockMedicalList() {

		List<Product> foodList = new ArrayList<Product>();

		for (int i = 0; i < 10; i++) {

			foodList.add(mockDrug(i));
		}

		return foodList;

	}

}

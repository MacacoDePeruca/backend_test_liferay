package com.liferay.vitornascimento.entities;

import java.util.ArrayList;
import java.util.List;

public class MockProducts {

	public double randomPrice() {

		double numero = ((int) ((Math.random() * 900) + 100) / 100.0);

		return numero;
	}

	public Product mockFood(Integer number) {

		return new Product(Math.random() * 100, "FOOD " + number, ProductCategory.FOOD, false);
	}

	public Product mockFoodwithPrice(Integer number, Double price) {

		return new Product(price, "FOOD " + number, ProductCategory.FOOD, false);
	}
	
	public Product mockImportedFoodwithPrice(Integer number, Double price) {
		
		return new Product(price, "FOOD " + number, ProductCategory.FOOD, true);
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

	public Product mockBookWithPrice(Integer number, Double price) {

		return new Product(price, "BOOK " + number, ProductCategory.BOOK, false);
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
	public Product mockDrugWithPrice(Integer number, Double price) {
		
		return new Product(price, "MEDICAL " + number, ProductCategory.MEDICAL, false);
	}

	public Product mockCommon(Integer number) {

		return new Product(Math.random() * 100, "Common item " + number, ProductCategory.COMMON, false);
	}

	public Product mockCommonPrice(Integer number, Double productPrice) {

		return new Product(productPrice, "Common item " + number, ProductCategory.COMMON, false);
	}

	

	/* IMPORTED PRODUCT */

	public Product mockImportedCommon(Integer number) {

		return new Product(randomPrice(), "Imported Common item " + number, ProductCategory.COMMON, true);
	}
	
	public Product mockImportedCommonPrice(Integer number, Double productPrice) {

		return new Product(productPrice, "Common item " + number, ProductCategory.COMMON, true);
	}

	public Product mockImportedBook(Integer number) {

		return new Product(Math.random() * 100, "Imported book " + number, ProductCategory.BOOK, true);
	}
	public Product mockImportedBookWithPrice(Integer number, Double price) {
		
		return new Product(price, "Imported book " + number, ProductCategory.BOOK, true);
	}

	public Product mockImportedDrug(Integer number) {

		return new Product(Math.random() * 100, "Imported drug " + number, ProductCategory.MEDICAL, true);
	}
	public Product mockImportedDrugWithPrice(Integer number, Double price) {
		
		return new Product(price, "Imported drug " + number, ProductCategory.MEDICAL, true);
	}

	public Product mockImportedFood(Integer number) {

		return new Product(Math.random() * 100, "Imported food " + number, ProductCategory.FOOD, true);
	}
	public Product mockImportedFoodWithPrice(Integer number, Double price) {
		
		return new Product(price, "Imported food " + number, ProductCategory.FOOD, true);
	}

	public List<Product> mockMedicalList() {

		List<Product> foodList = new ArrayList<Product>();

		for (int i = 0; i < 10; i++) {

			foodList.add(mockDrug(i));
		}

		return foodList;

	}

	public List<Product> mockInputOne() {
		List<Product> inputOne = new ArrayList<Product>();

		inputOne.add(mockBookWithPrice(1, 12.49));
		inputOne.add(mockCommonPrice(1, 14.99));
		inputOne.add(mockFoodwithPrice(1, 0.85));

		return inputOne;
	}

}

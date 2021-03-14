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
	
	public Product mockFoodwithPriceAndDescription(String description, Integer number, Double price) {

		return new Product(price, number+" "+description, ProductCategory.FOOD, false);
	}
	
	public Product mockImportedFoodwithPrice(Integer number, Double price) {
		
		return new Product(price, "FOOD " + number, ProductCategory.FOOD, true);
	}
	public Product mockImportedFoodwithPriceAndDescription(String description,Integer number, Double price) {
		
		return new Product(price,number+" "+description, ProductCategory.FOOD, true);
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
	public Product mockBookWithPriceAndDescription(String description, Integer number, Double price) {
		
		return new Product(price, number+" "+description , ProductCategory.BOOK, false);
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
	public Product mockDrugWithPriceAndDescription(String description, Integer number, Double price) {
		
		return new Product(price, number+ " "+description , ProductCategory.MEDICAL, false);
	}

	public Product mockCommon(Integer number) {

		return new Product(Math.random() * 100, "Common item " + number, ProductCategory.COMMON, false);
	}

	public Product mockCommonPrice(Integer number, Double productPrice) {

		return new Product(productPrice, "Common item " + number, ProductCategory.COMMON, false);
	}

	public Product mockCommonPriceAndDescription(String description,Integer number, Double productPrice) {

		return new Product(productPrice, number+" "+ description, ProductCategory.COMMON, false);
	}

	/* IMPORTED PRODUCT */

	public Product mockImportedCommon(Integer number) {

		return new Product(randomPrice(), "Imported Common item " + number, ProductCategory.COMMON, true);
	}
	
	public Product mockImportedCommonPrice(Integer number, Double productPrice) {

		return new Product(productPrice, "Common item " + number, ProductCategory.COMMON, true);
	}
	public Product mockImportedCommonPriceAndDescription(String description, Integer number, Double productPrice) {
		
		return new Product(productPrice, number+" "+description, ProductCategory.COMMON, true);
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

		inputOne.add(mockBookWithPriceAndDescription("book", 1, 12.49));
		inputOne.add(mockCommonPriceAndDescription("Music CD", 1, 14.99));
		inputOne.add(mockFoodwithPriceAndDescription("chocolate bar",1, 0.85));

		return inputOne;
	}
	
	public List<Product> mockInputTwo() {
		List<Product> inputTwo = new ArrayList<Product>();
		
		inputTwo.add(mockImportedFoodwithPriceAndDescription("imported box of chocolate",1 ,10.00));
		inputTwo.add(mockImportedCommonPriceAndDescription("imported bottle of perfume",1, 47.50));
		
		return inputTwo;
	}
	
	public List<Product> mockInputThree() {
		List<Product> inputThree = new ArrayList<Product>();
		
		inputThree.add(mockImportedCommonPriceAndDescription("imported bottle of perfume",1, 27.99));
		inputThree.add(mockCommonPriceAndDescription("bottle of perfume", 1, 18.99));
		inputThree.add(mockDrugWithPriceAndDescription("packet of headache pills",1, 9.75));
		inputThree.add(mockImportedFoodwithPriceAndDescription("imported box of chocolates", 1, 11.25));
		
		return inputThree;
	}

}

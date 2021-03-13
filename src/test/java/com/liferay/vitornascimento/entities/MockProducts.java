package com.liferay.vitornascimento.entities;

import java.util.ArrayList;
import java.util.List;

import com.liferay.vitornascimento.entities.Product;
import com.liferay.vitornascimento.entities.ProductCategory;

public class MockProducts {

	public Product mockFood(Integer number) {
		
		
		return new Product(Math.random()*100, "FOOD "+number, ProductCategory.FOOD, false); 
	}
	
	public List<Product> mockFoodList(){
		
		List<Product> foodList = new ArrayList<Product>();
		
		for (int i = 0; i < 10; i++) {
			
			foodList.add(mockFood(i));
		}
		
		return foodList;
		
	}
	public Product mockBook(Integer number) {
		
		
		return new Product(Math.random()*100, "BOOK "+number, ProductCategory.BOOK, false); 
	}
	
	public List<Product> mockBookList(){
		
		List<Product> foodList = new ArrayList<Product>();
		
		for (int i = 0; i < 10; i++) {
			
			foodList.add(mockBook(i));
		}
		
		return foodList;
		
	}
	public Product mockDrug(Integer number) {
		
		
		return new Product(Math.random()*100, "MEDICAL "+number, ProductCategory.MEDICAL, false); 
	}
	
	public List<Product> mockMedicalList(){
		
		List<Product> foodList = new ArrayList<Product>();
		
		for (int i = 0; i < 10; i++) {
			
			foodList.add(mockDrug(i));
		}
		
		return foodList;
		
	}
	
}

package com.liferay.vitornascimento.service;

import java.util.List;

import com.liferay.vitornascimento.entities.Product;
import com.liferay.vitornascimento.entities.ProductCorrector;


public class Billing {

	private List<ProductCorrector> validations;

	public Billing(List<ProductCorrector> validations) {
		this.validations = validations;
	}
	
	public Product invoice(Product product) {
		
		validations.forEach(v -> v.validate(product));
			
		return new Product(product);
		
	}
	
	
}

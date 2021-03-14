package com.liferay.vitornascimento.service;

import com.liferay.vitornascimento.entities.Product;
import com.liferay.vitornascimento.entities.ProductCorrector;

public class ValidatePrice implements ProductCorrector {

	private static final Double IMPORTATION_TAX = 0.05;

	@Override
	public void validate(Product product) {
		
		product.setPrice(
				product.isImported() ? product.getPrice() * (1 + product.getCategory().getValue() + IMPORTATION_TAX)
						: product.getPrice() * (1 + product.getCategory().getValue()));
		
	}

	

}

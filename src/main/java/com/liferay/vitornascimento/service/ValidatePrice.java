package com.liferay.vitornascimento.service;

import com.liferay.vitornascimento.entities.Product;
import com.liferay.vitornascimento.entities.Taxes;

public class ValidatePrice implements Taxes {

	private static final Double IMPORTATION_TAX = 0.05;

	@Override
	public void tribute(Product product) {
		product.setShelfPrice(product.getPrice());
		product.setPrice(
				product.isImported() ? product.getPrice() * (1 + product.getCategory().getValue() + IMPORTATION_TAX)
						: product.getPrice() * (1 + product.getCategory().getValue()));
		
		if( product.getPrice() != product.getShelfPrice()) {
			
			product.settaxed(true); 
		}
		
	}

	

}

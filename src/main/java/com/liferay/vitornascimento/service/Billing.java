package com.liferay.vitornascimento.service;

import java.util.List;

import com.liferay.vitornascimento.entities.AfterTaxes;
import com.liferay.vitornascimento.entities.Product;
import com.liferay.vitornascimento.entities.Taxes;

public class Billing {

	private List<Taxes> validations;
	private List<AfterTaxes> afterTaxes;

	public Billing(List<Taxes> validations, List<AfterTaxes> afterTaxes) {
		this.validations = validations;
		this.afterTaxes = afterTaxes;
	}

	public Product invoice(Product product) {

		validations.forEach(v -> {

			v.tribute(product);

		});

		if (product.istaxed())
			afterTaxes.forEach(t -> t.roundByFive(product));

		return new Product(product);

	}

}

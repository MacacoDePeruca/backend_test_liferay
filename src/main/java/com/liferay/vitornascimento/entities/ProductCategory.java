package com.liferay.vitornascimento.entities;

public enum ProductCategory {
	BOOK(0), FOOD(0), MEDICAL(0), COMMON(0.1);
	;

	private double value;

	private ProductCategory(double tax) {
		this.value = tax;
	}

	public Double getValue() {
		return this.value;
	}

}

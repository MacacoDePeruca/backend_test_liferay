package com.liferay.vitornascimento.entities;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

public class Receipt {

	private List<Product> buyedItens;
	private Double salesTaxes;
	private Double total;

	public Receipt(List<Product> buyedItens) {
		this.buyedItens = buyedItens;
		salesTaxes = 0.0;
		total = 0.0;
	}

	public Double getSalesTaxes() {
		return salesTaxes;
	}

	public void setSalesTaxes(Double salesTaxes) {
		this.salesTaxes = salesTaxes;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<Product> getBuyedItens() {
		return buyedItens;
	}

	public void incrementTotal(Double total) {
		this.total += total;
	}

	public void incrementSalesTax(Double salesTaxes) {
		this.salesTaxes += salesTaxes;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Sales taxes: "+new BigDecimal(salesTaxes).round(new MathContext(3)) +"\n"
				+ "Total : "+total;
	}
}

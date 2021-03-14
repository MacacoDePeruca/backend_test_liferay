package com.liferay.vitornascimento.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import com.liferay.vitornascimento.entities.Product;
import com.liferay.vitornascimento.entities.Receipt;

public class ReceiptGenerator {

	public static Receipt generate(List<Product> products) {
		
		
		new BigDecimal(1.0).round(new MathContext(1)).doubleValue();
		
		Receipt receipt = new Receipt(products);
		
		products.forEach(p -> {
			
			receipt.incrementTotal(new BigDecimal(p.getPrice())
					.round(new MathContext(4)).doubleValue());
			
			
			receipt.incrementSalesTax(new BigDecimal(p.getPrice() - p.getShelfPrice())
										.round(new MathContext(3)).doubleValue());  
		});
		
		return receipt;
	}
	
	
}

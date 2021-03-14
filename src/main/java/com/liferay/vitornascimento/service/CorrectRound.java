package com.liferay.vitornascimento.service;

import java.math.BigDecimal;
import java.math.MathContext;

import com.liferay.vitornascimento.entities.Product;
import com.liferay.vitornascimento.entities.ProductCorrector;

public class CorrectRound implements ProductCorrector{

	@Override
	public void validate(Product product) {

       double price = product.getPrice();
		
		BigDecimal big = new BigDecimal(price%0.05 * 100).round(new MathContext(1));
		
		int cents = big.intValue();
		
		if( cents <= 2 && cents !=0 ) {
			
			price = price*100 - cents;
			price = price/100;
			product.setPrice(price);
			
		}else {
			int faltaPraCinco = 5 - cents;
			
			price = price * 100 + faltaPraCinco;
			price = price/100;
			product.setPrice(price);
			
		}
			
	
		
	}

}

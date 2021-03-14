package com.liferay.vitornascimento.service;

import java.math.BigDecimal;
import java.math.MathContext;

import com.liferay.vitornascimento.entities.AfterTaxes;
import com.liferay.vitornascimento.entities.Product;

public class CorrectRound implements AfterTaxes{

	@Override
	public void roundByFive(Product product) {

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

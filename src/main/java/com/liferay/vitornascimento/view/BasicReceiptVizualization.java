package com.liferay.vitornascimento.view;

import com.liferay.vitornascimento.entities.Receipt;

public class BasicReceiptVizualization implements ShowReceipt {

	@Override
	public void writeReceipt(Receipt receipt) {
		
		receipt.getBuyedItens().forEach(System.out::println);
		System.out.println(receipt);
		
		
	}
	


}

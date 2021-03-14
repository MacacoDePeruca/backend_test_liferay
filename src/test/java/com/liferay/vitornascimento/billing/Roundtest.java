package com.liferay.vitornascimento.billing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.liferay.vitornascimento.entities.MockProducts;
import com.liferay.vitornascimento.entities.Product;
import com.liferay.vitornascimento.entities.ProductCorrector;
import com.liferay.vitornascimento.service.Billing;
import com.liferay.vitornascimento.service.CorrectRound;

public class Roundtest {

	
	MockProducts inputObject;
	Billing billing;
	List<ProductCorrector> validations = new ArrayList<>();;

	@Before
	public void setUp() {
		inputObject = new MockProducts();
		validations.add(new CorrectRound());
		

		billing = new Billing(validations);

	}
	
	@Test
	public void roundToFiveCentsTest() {
		
		Product common = inputObject.mockCommonPrice(0,10.44);
		Product common1 = inputObject.mockCommonPrice(0,10.45);
		Product common2 = inputObject.mockCommonPrice(0,10.46);
		Product common3 = inputObject.mockCommonPrice(0,10.47);
		Product common4 = inputObject.mockCommonPrice(0,10.48);
		Product common5 = inputObject.mockCommonPrice(0,10.49);
		
		assertEquals(10.45, billing.invoice(common).getPrice(), 0.001); 
		assertEquals(10.45, billing.invoice(common1).getPrice(), 0.001); 
		assertEquals(10.45, billing.invoice(common2).getPrice(), 0.001); 
		assertEquals(10.45, billing.invoice(common3).getPrice(), 0.001); 
		assertEquals(10.50, billing.invoice(common4).getPrice(), 0.001); 
		assertEquals(10.50, billing.invoice(common5).getPrice(), 0.001); 
		
	}
}

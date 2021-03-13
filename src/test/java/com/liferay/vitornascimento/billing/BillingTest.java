package com.liferay.vitornascimento.billing;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.liferay.vitornascimento.entities.MockProducts;
import com.liferay.vitornascimento.entities.Product;

public class BillingTest {
	
	
	MockProducts  inputObject;

	    @Before
	    public void setUp() {
	        inputObject = new MockProducts();
	    }

	@Test
	public void foodBuyingTest() {

		Product food = inputObject.mockFood(0);

		assertEquals(food.getPrice(), food.getPrice()/* billing method */ ); // non imported food have no taxes
	}
	
	@Test
	public void drugsBuyingTest() {

		Product medical =  inputObject.mockDrug(0);

		assertEquals(medical.getPrice(), null/* billing method */ ); // non imported drugs have no taxes
	}
	
	@Test
	public void bookBuyingTest() {

		Product book = inputObject.mockBook(0);

		assertEquals(book.getPrice(), null/* billing method */ ); // non imported books have no taxes
	}

}

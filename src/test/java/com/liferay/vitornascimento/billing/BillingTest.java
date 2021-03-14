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
import com.liferay.vitornascimento.service.ValidatePrice;

public class BillingTest {

	MockProducts inputObject;
	Billing billing;
	List<ProductCorrector> validations = new ArrayList<>();;

	@Before
	public void setUp() {
		inputObject = new MockProducts();
		validations.add(new ValidatePrice());
		

		billing = new Billing(validations);

	}

	@Test
	public void foodBuyingTest() {

		Product food = inputObject.mockFood(0);

		assertEquals(Double.compare(billing.invoice(food).getPrice(), food.getPrice()), 0); // non imported food have no
																							// taxes
	}

	@Test
	public void drugsBuyingTest() {

		Product drug = inputObject.mockDrug(0);

		assertEquals(Double.compare(billing.invoice(drug).getPrice(), drug.getPrice()), 0); // non imported drugs have
																							// no taxes

	}

	@Test
	public void bookBuyingTest() {

		Product book = inputObject.mockBook(0);

		assertEquals(Double.compare(billing.invoice(book).getPrice(), book.getPrice()), 0); // non imported books have
																							// no taxes

		;

	}

	@Test
	public void BuyingCommonProductNotImportedTest() {

		Product common = inputObject.mockCommon(0);

		assertEquals(common.getPrice() * 1.10, billing.invoice(common).getPrice(), 0); // non imported common itens have
																						// 10% tax

		;

	}
	@Test
	public void BuyingCommonImportedProductTest() {
		
		Product common = inputObject.mockImportedCommon(0);
		
		
		assertEquals(common.getPrice() * 1.15, billing.invoice(common).getPrice(), 0.001); 
		// non imported common itens have 15% tax ( 10 by category and 5 by importation)
	}
	
	@Test
	public void BuyingImportedBookTest() {
		
		Product common = inputObject.mockImportedBook(0);
		
		assertEquals(common.getPrice() * 1.05, billing.invoice(common).getPrice(), 0.001);
		//  imported book have 5% tax ( 0 by category and 5 by importation)
	}
	@Test
	public void BuyingImportedDrugTest() {
		
		Product common = inputObject.mockImportedDrug(0);
		
		assertEquals(common.getPrice() * 1.05, billing.invoice(common).getPrice(),0.001); //  imported book have 5% tax ( 0 by category and 5 by importation)
	}
	@Test
	public void BuyingImportedFoodTest() {
		
		Product common = inputObject.mockImportedFood(0);
		
		assertEquals(common.getPrice() * 1.05, billing.invoice(common).getPrice(), 0.001); //  imported book have 5% tax ( 0 by category and 5 by importation)
	}
	
	

}

package com.liferay.vitornascimento.billing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.liferay.vitornascimento.entities.AfterTaxes;
import com.liferay.vitornascimento.entities.MockProducts;
import com.liferay.vitornascimento.entities.Product;
import com.liferay.vitornascimento.entities.Taxes;
import com.liferay.vitornascimento.service.Billing;
import com.liferay.vitornascimento.service.CorrectRound;
import com.liferay.vitornascimento.service.ValidatePrice;

public class BillingTest {

	MockProducts inputObject;
	Billing billing;

	List<Taxes> validations = new ArrayList<>();
	List<AfterTaxes> afterAjusts = new ArrayList<>();

	@Before
	public void setUp() {
		inputObject = new MockProducts();
		validations.add(new ValidatePrice());
		afterAjusts.add(new CorrectRound());

		billing = new Billing(validations, afterAjusts);

	}

	@Test
	public void foodBuyingTest() {

		Product food = inputObject.mockFood(0);

		assertEquals(billing.invoice(food).getPrice(), food.getPrice(), 0.01); // non imported food have no
																							// taxes
	}

	@Test
	public void drugsBuyingTest() {

		Product drug = inputObject.mockDrug(0);

		assertEquals(billing.invoice(drug).getPrice(), drug.getPrice(), 0.01); // non imported drugs have
																							// no taxes

	}

	@Test
	public void bookBuyingTest() {

		Product book = inputObject.mockBook(0);

		assertEquals(billing.invoice(book).getPrice(), book.getPrice(), 0.01); // non imported books have
																							// no taxes

		;

	}

	@Test
	public void BuyingCommonProductNotImportedTest() {

		Product common = inputObject.mockCommon(0);

		assertEquals(common.getPrice() * 1.10, billing.invoice(common).getPrice(), 0.01); // non imported common itens have
																						// 10% tax

		;

	}

	@Test
	public void BuyingCommonImportedProductTest() {

		Product common = inputObject.mockImportedCommonPrice(0, 10.00);

		assertEquals(11.55, billing.invoice(common).getPrice(), 0.001);
		// non imported common itens have 15% tax ( 10 by category and 5 by importation)
	}

	@Test
	public void BuyingImportedBookTest() {

		Product common = inputObject.mockImportedBookWithPrice(0, 10.0);

		assertEquals(10.50, billing.invoice(common).getPrice(), 0.001);
		// imported book have 5% tax ( 0 by category and 5 by importation)
	}

	@Test
	public void BuyingImportedDrugTest() {

		Product common = inputObject.mockImportedDrugWithPrice(0, 10.00);

		assertEquals(10.50, billing.invoice(common).getPrice(), 0.001); // imported book have 5% tax
																		// ( 0 by category and 5 by
																		// importation)
	}

	@Test
	public void BuyingImportedFoodTest() {

		Product common = inputObject.mockImportedFoodwithPrice(0, 15.60);

		assertEquals(16.40, billing.invoice(common).getPrice(), 0.001); // imported book have 5% tax
																		// ( 0 by category and 5 by
																		// importation)
																		// + 2 cents round
	}

	@Test
	public void inputOneTest() {

		Product book = inputObject.mockBookWithPrice(1, 12.49);
		Product musicCD = inputObject.mockCommonPrice(1, 14.99);
		Product chocolatBar = inputObject.mockFoodwithPrice(1, 0.85);

		assertEquals(12.49, billing.invoice(book).getPrice(), 0.001);
		assertEquals(16.49, billing.invoice(musicCD).getPrice(), 0.001);
		assertEquals(0.85, billing.invoice(chocolatBar).getPrice(), 0.001);

	}

	@Test
	public void inputTwoTest() {

		Product importedPerfume = inputObject.mockImportedCommonPrice(1, 47.50);

		Product importedBoxOfChocolatBar = inputObject.mockImportedFoodwithPrice(1, 10.00);

		assertEquals(54.65, billing.invoice(importedPerfume).getPrice(), 0.01); 
		assertEquals(10.50, billing.invoice(importedBoxOfChocolatBar).getPrice(), 0.001);

	}

	@Test
	public void inputThreeTest() {

		Product importedPerfume = inputObject.mockImportedCommonPrice(1, 27.99);
		Product perfume = inputObject.mockCommonPrice(1, 18.99);
		Product pills = inputObject.mockDrugWithPrice(1, 9.75);
		Product importedBoxOfChocolatBar = inputObject.mockImportedFoodwithPrice(1, 11.25);

		assertEquals(32.20, billing.invoice(importedPerfume).getPrice(), 0.01);
		assertEquals(20.89, billing.invoice(perfume).getPrice(), 0.01);
		assertEquals(9.75, billing.invoice(pills).getPrice(), 0.01);
		assertEquals(11.85, billing.invoice(importedBoxOfChocolatBar).getPrice(), 0.01);

	}

}

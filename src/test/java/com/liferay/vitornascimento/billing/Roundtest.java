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

public class Roundtest {

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
	public void roundToFiveCentsTest() {

		Product common = inputObject.mockImportedCommonPrice(0, 9.99);

		assertEquals(11.50, billing.invoice(common).getPrice(), 0.01);

	}
}

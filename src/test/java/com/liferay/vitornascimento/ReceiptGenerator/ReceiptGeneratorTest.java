package com.liferay.vitornascimento.ReceiptGenerator;

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
import com.liferay.vitornascimento.service.ReceiptGenerator;
import com.liferay.vitornascimento.service.ValidatePrice;
import com.liferay.vitornascimento.view.BasicReceiptVizualization;

public class ReceiptGeneratorTest {
	MockProducts inputObject;
	Billing billing;
	List<Taxes> validations;
	List<AfterTaxes> afterAjusts;

	BasicReceiptVizualization show;

	@Before
	public void setUp() {
		inputObject = new MockProducts();
		validations = new ArrayList<>();
		afterAjusts = new ArrayList<>();
		show = new BasicReceiptVizualization();

		validations.add(new ValidatePrice());
		afterAjusts.add(new CorrectRound());

		billing = new Billing(validations, afterAjusts);

	}

	@Test
	public void inputOneGenerateReceipt() {

		List<Product> billedProducts = new ArrayList<>();

		inputObject.mockInputOne().forEach(p -> billedProducts.add(billing.invoice(p)));

		show.writeReceipt(ReceiptGenerator.generate(billedProducts));
		System.out.println("---------------------------------------");
	}

	@Test
	public void inputTwoGenerateReceipt() {

		List<Product> billedProducts = new ArrayList<>();

		inputObject.mockInputTwo().forEach(p -> billedProducts.add(billing.invoice(p)));

		show.writeReceipt(ReceiptGenerator.generate(billedProducts));
		System.out.println("---------------------------------------");
	}

	@Test
	public void inputThreeGenerateReceipt() {

		List<Product> billedProducts = new ArrayList<>();

		inputObject.mockInputThree().forEach(p -> billedProducts.add(billing.invoice(p)));

		show.writeReceipt(ReceiptGenerator.generate(billedProducts));
		System.out.println("---------------------------------------");
	}
}

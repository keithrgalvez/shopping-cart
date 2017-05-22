package com.shoppingcart.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;

import org.junit.Test;

import com.shoppingcart.model.ShoppingCart;
import com.shoppingcart.model.Product;
import com.shoppingcart.service.ProductService;
import com.shoppingcart.service.impl.ProductServiceImpl;

public class ShoppingCartTest {

	private ProductService productService = new ProductServiceImpl();

	@Test
	public void testScenario1() {
		ShoppingCart cart = new ShoppingCart();

		Product small = productService.getProduct("ult_small");
		Product large = productService.getProduct("ult_large");

		for (int i = 0; i < 3; i++) {
			cart.add(small);
		}
		cart.add(large);

		assertEquals(new BigDecimal(94.70).setScale(2, RoundingMode.HALF_UP), cart.getTotal());
		assertSame(3, Collections.frequency(cart.getAllItems(), small));
		assertSame(1, Collections.frequency(cart.getAllItems(), large));
	}

	@Test
	public void testScenario2() {
		ShoppingCart cart = new ShoppingCart();

		Product small = productService.getProduct("ult_small");
		Product large = productService.getProduct("ult_large");

		for (int i = 0; i < 2; i++) {
			cart.add(small);
		}

		for (int i = 0; i < 4; i++) {
			cart.add(large);
		}

		assertEquals(new BigDecimal(209.40).setScale(2, RoundingMode.HALF_UP), cart.getTotal());
		assertSame(2, Collections.frequency(cart.getAllItems(), small));
		assertSame(4, Collections.frequency(cart.getAllItems(), large));
	}

	@Test
	public void testScenario3() {
		ShoppingCart cart = new ShoppingCart();

		Product small = productService.getProduct("ult_small");
		Product medium = productService.getProduct("ult_medium");
		Product oneGbDataPack = productService.getProduct("1gb");

		cart.add(small);
		for (int i = 0; i < 2; i++) {
			cart.add(medium);
		}

		assertEquals(new BigDecimal(84.70).setScale(2, RoundingMode.HALF_UP), cart.getTotal());
		assertSame(1, Collections.frequency(cart.getAllItems(), small));
		assertSame(2, Collections.frequency(cart.getAllItems(), medium));
		assertSame(2, Collections.frequency(cart.getAllItems(), oneGbDataPack));
	}

	@Test
	public void testScenario4() {
		ShoppingCart cart = new ShoppingCart();

		Product small = productService.getProduct("ult_small");
		Product oneGbDataPack = productService.getProduct("1gb");

		cart.add(small);
		cart.add(oneGbDataPack, "I<3AMAYSIM");
	}
}

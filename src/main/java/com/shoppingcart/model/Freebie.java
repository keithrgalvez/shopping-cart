package com.shoppingcart.model;

public class Freebie extends Promo {

	private Product product;

	public Freebie(String code, Product product) {
		super(code, PromoType.FREEBIE);
		this.product = product;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

}

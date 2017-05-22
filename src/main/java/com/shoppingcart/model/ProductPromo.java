package com.shoppingcart.model;

public class ProductPromo {

	private Product product;
	private Promo promo;

	public ProductPromo(final Product product, final Promo promo) {
		this.product = product;
		this.promo = promo;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @return the promo
	 */
	public Promo getPromo() {
		return promo;
	}

}

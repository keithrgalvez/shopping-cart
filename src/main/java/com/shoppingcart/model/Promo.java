package com.shoppingcart.model;

public class Promo {

	private String code;
	private PromoType type;

	public Promo(String code, PromoType type) {
		this.code = code;
		this.type = type;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the type
	 */
	public PromoType getType() {
		return type;
	}
}

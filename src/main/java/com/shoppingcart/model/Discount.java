package com.shoppingcart.model;

public class Discount extends Promo {

	private double percentageDiscount;

	public Discount(String code, double percentageDiscount) {
		super(code, PromoType.DISCOUNT);
		this.percentageDiscount = percentageDiscount;
	}

	/**
	 * @return the percentageDiscount
	 */
	public double getPercentageDiscount() {
		return percentageDiscount;
	}

}

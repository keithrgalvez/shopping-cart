package com.shoppingcart.model;

import java.math.BigDecimal;

public class Bulk extends Promo {

	private BigDecimal bulkPrice;

	public Bulk(String code, BigDecimal bulkPrice) {
		super(code, PromoType.BULK);
		this.bulkPrice = bulkPrice;
	}

	/**
	 * @return the bulkPrice
	 */
	public BigDecimal getBulkPrice() {
		return bulkPrice;
	}
}

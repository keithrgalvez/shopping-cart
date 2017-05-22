package com.shoppingcart.rule;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;

import com.shoppingcart.model.ShoppingCart;
import com.shoppingcart.model.ProductPromo;

public class DealRule extends PricingRule {

	public DealRule(final ProductPromo productPromo) {
		super(productPromo);
	}

	@Override
	public void applyPromo(final ShoppingCart cart) {
		ProductPromo promo = this.getProductPromo();

		int total = Collections.frequency(cart.getPurchases(), promo.getProduct());

		if ((total % 3)==0) {
			BigDecimal newTotal = cart.getTotal().subtract(promo.getProduct().getPrice());
			cart.setTotal(newTotal.setScale(2, RoundingMode.HALF_UP));
		}
	}

}

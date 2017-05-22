package com.shoppingcart.rule;

import com.shoppingcart.model.ShoppingCart;
import com.shoppingcart.model.ProductPromo;

public abstract class PricingRule {

	private ProductPromo productPromo;

	public PricingRule(final ProductPromo productPromo) {
		this.productPromo = productPromo;
	}

	public abstract void applyPromo(ShoppingCart cart);

	protected ProductPromo getProductPromo() {
		return this.productPromo;
	}

}

package com.shoppingcart.rule;

import com.shoppingcart.model.ShoppingCart;
import com.shoppingcart.model.Freebie;
import com.shoppingcart.model.ProductPromo;

public class FreebieRule extends PricingRule {

	public FreebieRule(final ProductPromo productPromo) {
		super(productPromo);
	}

	@Override
	public void applyPromo(final ShoppingCart cart) {
		ProductPromo productPromo = this.getProductPromo();

		Freebie freebie = (Freebie) productPromo.getPromo();
		cart.addFreebie(freebie.getProduct());
	}

}

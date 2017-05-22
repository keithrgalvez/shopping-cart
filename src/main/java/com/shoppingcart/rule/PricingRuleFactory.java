package com.shoppingcart.rule;

import com.shoppingcart.model.ProductPromo;

public final class PricingRuleFactory {

	public PricingRule getPricingRule(final ProductPromo productPromo) {
		switch (productPromo.getPromo().getType()) {
		case DEAL:
			return new DealRule(productPromo);
		case BULK:
			return new BulkRule(productPromo);
		case FREEBIE:
			return new FreebieRule(productPromo);
		default:
			return null;
		}
	}

}

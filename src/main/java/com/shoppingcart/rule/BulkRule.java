package com.shoppingcart.rule;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;

import com.shoppingcart.model.Bulk;
import com.shoppingcart.model.ShoppingCart;
import com.shoppingcart.model.Product;
import com.shoppingcart.model.ProductPromo;

public class BulkRule extends PricingRule {

	public BulkRule(final ProductPromo productPromo) {
		super(productPromo);
	}

	@Override
	public void applyPromo(final ShoppingCart cart) {
		ProductPromo productPromo = this.getProductPromo();

		Product product = productPromo.getProduct();
		int total = Collections.frequency(cart.getPurchases(), product);

		if (total > 3) {
			Bulk bulkPromo = (Bulk) productPromo.getPromo();
			BigDecimal lessPrice = product.getPrice().subtract(bulkPromo.getBulkPrice());
			
			BigDecimal newTotal = cart.getTotal();
			for (int i = 0; i < total; i++) {
				newTotal = newTotal.subtract(lessPrice);
			}
			
			cart.setTotal(newTotal.setScale(2, RoundingMode.HALF_UP));
		}
	}

}

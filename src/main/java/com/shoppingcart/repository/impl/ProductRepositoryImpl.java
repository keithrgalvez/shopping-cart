package com.shoppingcart.repository.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.shoppingcart.model.Bulk;
import com.shoppingcart.model.Freebie;
import com.shoppingcart.model.Product;
import com.shoppingcart.model.ProductPromo;
import com.shoppingcart.model.Promo;
import com.shoppingcart.model.PromoType;
import com.shoppingcart.repository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {

	private static Map<String, Product> productMap = new HashMap<>();

	private static Map<String, Promo> promoMap = new HashMap<>();

	static {
		productMap.put("ult_small", new Product("ult_small", "Unlimited 1GB", new BigDecimal(24.90)));
		productMap.put("ult_medium", new Product("ult_medium", "Unlimited 2GB", new BigDecimal(29.90)));
		productMap.put("ult_large", new Product("ult_large", "Unlimited 5GB", new BigDecimal(44.90)));
		productMap.put("1gb", new Product("1gb", "1 GB Data-pack", new BigDecimal(9.90)));

		promoMap.put("ult_small", new Promo("3for2", PromoType.DEAL));
		promoMap.put("ult_medium", new Freebie("free1gb", productMap.get("1gb")));
		promoMap.put("ult_large", new Bulk("bulk3", new BigDecimal(39.90)));
	}

	@Override
	public Product getProduct(final String productCode) {
		return productMap.get(productCode);
	}

	@Override
	public ProductPromo getProductPromo(final Product product) {
		ProductPromo productPromo = new ProductPromo(product, promoMap.get(product.getCode()));
		return productPromo;
	}
}

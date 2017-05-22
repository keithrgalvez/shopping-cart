package com.shoppingcart.repository.impl;

import java.util.HashMap;
import java.util.Map;

import com.shoppingcart.model.Discount;
import com.shoppingcart.model.Promo;
import com.shoppingcart.repository.PromoRepository;

public class PromoRepositoryImpl implements PromoRepository {
	private static Map<String, Promo> promoMap = new HashMap<>();

	static {
		promoMap.put("I<3AMAYSIM", new Discount("I<3AMAYSIM", 10));
	}

	@Override
	public Promo getPromo(final String promoCode) {
		return promoMap.get(promoCode);
	}

}

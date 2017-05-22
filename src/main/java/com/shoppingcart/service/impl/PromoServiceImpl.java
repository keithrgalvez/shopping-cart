package com.shoppingcart.service.impl;

import com.shoppingcart.model.Promo;
import com.shoppingcart.repository.PromoRepository;
import com.shoppingcart.repository.impl.PromoRepositoryImpl;
import com.shoppingcart.service.PromoService;

public class PromoServiceImpl implements PromoService {

	private PromoRepository repository = new PromoRepositoryImpl();

	@Override
	public Promo getPromo(final String promoCode) {
		return repository.getPromo(promoCode);
	}

}

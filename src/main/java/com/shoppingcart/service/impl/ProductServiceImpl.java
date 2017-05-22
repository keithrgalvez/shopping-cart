package com.shoppingcart.service.impl;

import com.shoppingcart.model.Product;
import com.shoppingcart.model.ProductPromo;
import com.shoppingcart.repository.ProductRepository;
import com.shoppingcart.repository.impl.ProductRepositoryImpl;
import com.shoppingcart.service.ProductService;

public class ProductServiceImpl implements ProductService {

	private ProductRepository repository = new ProductRepositoryImpl();

	@Override
	public Product getProduct(String productCode) {
		return repository.getProduct(productCode);
	}

	@Override
	public ProductPromo getProductPromo(final Product product) {
		return repository.getProductPromo(product);
	}

}

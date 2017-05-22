package com.shoppingcart.repository;

import com.shoppingcart.model.Product;
import com.shoppingcart.model.ProductPromo;

public interface ProductRepository {

	Product getProduct(String productCode);

	ProductPromo getProductPromo(Product product);
}

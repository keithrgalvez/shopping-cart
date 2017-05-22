package com.shoppingcart.service;

import com.shoppingcart.model.Product;
import com.shoppingcart.model.ProductPromo;

public interface ProductService {

	Product getProduct(String productCode);

	ProductPromo getProductPromo(Product product);

}

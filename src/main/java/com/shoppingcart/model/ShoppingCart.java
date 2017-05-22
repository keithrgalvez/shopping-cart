package com.shoppingcart.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.shoppingcart.rule.PricingRule;
import com.shoppingcart.rule.PricingRuleFactory;
import com.shoppingcart.service.ProductService;
import com.shoppingcart.service.PromoService;
import com.shoppingcart.service.impl.ProductServiceImpl;
import com.shoppingcart.service.impl.PromoServiceImpl;

public class ShoppingCart {

	private PromoService promoService = new PromoServiceImpl();
	private ProductService productService = new ProductServiceImpl();

	private List<Product> purchases = new ArrayList<>();
	private List<Product> freebies = new ArrayList<>();
	private BigDecimal total = BigDecimal.ZERO;

	private double percentageDiscount;

	public void add(Product product) {
		purchases.add(product);
		total = total.add(product.getPrice()).setScale(2, RoundingMode.HALF_UP);
		checkAndApplyProductPromos(product);
	}

	public void add(Product product, String promoCode) {
		purchases.add(product);
		applyDiscountPromo(promoCode);
	}

	public void addFreebie(Product product) {
		freebies.add(product);
	}

	private void checkAndApplyProductPromos(Product product) {
		ProductPromo productPromo = productService.getProductPromo(product);

		if (productPromo == null) {
			return;
		}

		PricingRuleFactory factory = new PricingRuleFactory();
		applyPromo(factory.getPricingRule(productPromo));
	}

	private void applyPromo(PricingRule rule) {
		if (rule != null) {
			rule.applyPromo(this);
		}
	}

	private void applyDiscountPromo(final String promoCode) {
		Discount discount = (Discount) promoService.getPromo(promoCode);
		if (discount != null) {
			this.setPercentageDiscount(discount.getPercentageDiscount());
		}
	}

	/**
	 * @return the purchases
	 */
	public List<Product> getPurchases() {
		return purchases;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	/**
	 * @return the total
	 */
	public BigDecimal getTotal() {
		if (percentageDiscount > 0) {
			BigDecimal percentage = new BigDecimal(percentageDiscount / 100);
			return total.subtract(total.multiply((percentage)));
		}
		return total;
	}

	/**
	 * @return the freebies
	 */
	public List<Product> getFreebies() {
		return freebies;
	}

	/**
	 * @param percentageDiscount
	 *            the percentageDiscount to set
	 */
	public void setPercentageDiscount(double percentageDiscount) {
		this.percentageDiscount = percentageDiscount;
	}

	public List<Product> getAllItems() {
		List<Product> allItems = new ArrayList<>();

		allItems.addAll(purchases);
		allItems.addAll(freebies);

		return allItems;
	}
}

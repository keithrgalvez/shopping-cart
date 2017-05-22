package com.shoppingcart.model;

import java.math.BigDecimal;

public class Product {

	private String code;
	private String name;
	private BigDecimal price;
	
	public Product(String code, String name, BigDecimal price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}

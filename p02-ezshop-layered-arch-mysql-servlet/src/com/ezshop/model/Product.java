package com.ezshop.model;

public class Product {
	private String productId;
	private String productName;
	private float price;
	private int quantity;

	// Writing accessors and mutators
	public float getPrice() {
		return price;
	}

	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", quantity="
				+ quantity + "]";
	}

}
	
	
package com.ezshop.service;

import java.util.List;

import com.ezshop.model.Product;
import com.ezshop.repository.ProductRepository;

public class ProductService {

	public Product getFirstProduct() {

		Product product = null;
		ProductRepository productRepository = new ProductRepository();
		product = productRepository.getFirstProduct();
		// the service layer applies the discount (business logic)
		product.setPrice(product.getPrice() - 50);
		return product;
	}

	public List<Product> getProducts() {
		ProductRepository productRepository = new ProductRepository();
		List<Product> products = productRepository.getProducts();
		return products;

		// return new ProductRepository().getProducts();
	}
}


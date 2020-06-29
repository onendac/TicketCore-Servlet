package com.ezshop.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ezshop.model.Product;

public class ProductRepository {
	public Product getFirstProduct() {
		try {
			// product fetched from the db
			Product product = new Product();
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ezshopdb", "root",
					"mysql");
			System.out.println("Connection Established!");

			// create the statement
			Statement statement = connection.createStatement();
			System.out.println("Statement created!");
			// Fetch the results by executing the query
			ResultSet resultSet = statement.executeQuery("select * from product");
			// Iterate the resultSet
			if (resultSet.next()) {
				product.setProductId(resultSet.getString(("product_id")));
				product.setProductName(resultSet.getString("product_name"));
				product.setPrice(resultSet.getFloat("price"));
				product.setQuantity(resultSet.getInt("quantity"));
			}
			resultSet.close();
			statement.close();
			connection.close();
			return product;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
		return null;
	}

	public List<Product> getProducts() {
		try {
			// products fetched from the db
			List productsList = new ArrayList<Product>();
			Product product = new Product();
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ezshopdb", "root",
					"mysql");
			System.out.println("Connection Established!");

			// create the statement
			Statement statement = connection.createStatement();
			System.out.println("Statement created!");
			// Fetch the results by executing the query
			ResultSet resultSet = statement.executeQuery("select * from product");
			// Iterate the resultSet
			while (resultSet.next()) {
				product.setProductId(resultSet.getString(("product_id")));
				product.setProductName(resultSet.getString("product_name"));
				product.setPrice(resultSet.getFloat("price"));
				product.setQuantity(resultSet.getInt("quantity"));
				productsList.add(product);
			}
			resultSet.close();
			statement.close();
			connection.close();
			System.out.println(productsList);
			return productsList;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
		return null;
	}
	
}

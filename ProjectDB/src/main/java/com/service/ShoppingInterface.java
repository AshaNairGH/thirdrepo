package com.service;

import com.app.Product;

public interface ShoppingInterface {
		void addProduct(Product product, int quantity);
		void viewProduct();
		double totalAmount();	
	}


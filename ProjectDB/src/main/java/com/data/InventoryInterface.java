package com.data;

import java.util.List;

import com.app.Product;

public interface InventoryInterface {
		List<Product> searchProducts(String productpartialname);
		List<Product> searchProductids(int productid);
		void displayItems();
	}

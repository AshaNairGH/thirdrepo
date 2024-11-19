package com.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Stream;

import com.app.Product;

public class Inventory implements InventoryInterface{
private List<Product> lproducts;

public Inventory(List<Product> lproducts) {
	this.lproducts = lproducts;
}

public Inventory() {
	lproducts = new ArrayList<>();
}
/*
 * 
 * lproducts.add(new Product(1,"Oppo Mobile","6GB RAM","Electronics",18550.00));
 * lproducts.add(new Product(2,"Samsung TV","43 inch","Electronics",42990.00));
 * lproducts.add(new
 * Product(3,"Recliner","Single seater","Furniture",15999.00));
 * lproducts.add(new Product(4,"Toy Truck","Plastic","Toys",565.00));
 * lproducts.add(new
 * Product(5,"Coffee Table","Round wooden","Furniture",9999.00));
 * lproducts.add(new Product(6,"Flash Cards","Educational","Toys",398.00));
 * lproducts.add(new Product(7,"Shoes","Sports wear","Footwear",1120.00));
 * lproducts.add(new
 * Product(8,"Redmi Mobile","4GB RAM","Electronics",15500.00));
 * lproducts.add(new Product(9,"Shoes","Formal wear","Footwear",1599.00));
 * lproducts.add(new Product(10,"Shoes","Casual wear","Footwear",890.00));
 * 
 * }
 * 
 * @Override //Search products with name public List<Product>
 * searchProducts(String productpartialname){ return
 * lproducts.stream().filter(e->e.getProduct_name().toLowerCase().
 * contains(productpartialname.toLowerCase())).toList(); }
 * 
 * @Override //Search products with product id public List<Product>
 * searchProductids(int productid){ return
 * lproducts.stream().filter(e->e.getProduct_id()==(productid)).toList(); }
 * 
 * @Override //List available products public void displayItems(){
 * lproducts.forEach((item)->{ System.out.println(item); }); }
 */

//Search products with name
public List<Product> searchProducts(String productpartialname)   {		
		Product product = null;
		Connection connection= null;
		lproducts.clear();
		try {			
		connection = DBConnection.getDbConnection();
		PreparedStatement ps = connection.prepareStatement("select * from Inventory where ProductName like ?");
		productpartialname = productpartialname.toLowerCase().concat("%");

		ps.setString(1, productpartialname);
		 ResultSet resultset = ps.executeQuery();
		if (!resultset.isBeforeFirst())
		{
			System.out.println("Product Unavailable!");
		}else {

		while (resultset.next()) {

			product = new Product(resultset.getInt("ID"), resultset.getString("ProductName"),
					resultset.getString("Category"), resultset.getString("Specification"), resultset.getDouble("Price"));
			lproducts.add(product);
		}
		}
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		finally {

			DBConnection.closeConnection(connection);
		}
		return lproducts;	
		
	}

//Search products with product id
public List<Product> searchProductids(int productid) {
	 Product product = null;
	 Connection connection= null;
	 lproducts.clear();
	try {
		connection = DBConnection.getDbConnection();
		PreparedStatement ps = connection.prepareStatement("select * from Inventory where ID= ? ");

		ps.setInt(1, productid);
		ResultSet resultset = ps.executeQuery();

		while (resultset.next()) {

			product = new Product(resultset.getInt("ID"), resultset.getString("ProductName"),
					resultset.getString("Category"), resultset.getString("Specification"), resultset.getDouble("Price"));

			lproducts.add(product);

		}

		return lproducts;
	} catch (Exception e) {

		System.out.println(e.getStackTrace());
	}

	finally {

		DBConnection.closeConnection(connection);
	}
	return lproducts;
}

//List available products
public void displayItems() {
		Connection connection = null;
		try {
			connection = DBConnection.getDbConnection();
			PreparedStatement ps = connection.prepareStatement("select * from Inventory ");
			ResultSet resultset = ps.executeQuery();

			while (resultset.next()) {

				Product product = new Product(resultset.getInt("ID"), resultset.getString("ProductName"),
						resultset.getString("Category"), resultset.getString("Specification"), resultset.getDouble("Price"));
				
				System.out.println(product);
			}
		}
		catch (SQLException e) {

			e.printStackTrace();

		} finally {
			DBConnection.closeConnection(connection);
		}
	}
}

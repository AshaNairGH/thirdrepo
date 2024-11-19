package com.app;

public class Product {
private int product_id;
private String product_name;
private String product_specification;
private String product_Category;
private double product_price;

public Product(int product_id, String product_name, String product_specification, String product_Category,
		double product_price) {
	this.product_id = product_id;
	this.product_name = product_name;
	this.product_specification = product_specification;
	this.product_Category = product_Category;
	this.product_price = product_price;
}

public int getProduct_id() {
	return product_id;
}

public void setProduct_id(int product_id) {
	this.product_id = product_id;
}

public String getProduct_name() {
	return product_name;
}

public void setProduct_name(String product_name) {
	this.product_name = product_name;
}

public String getProduct_specification() {
	return product_specification;
}

public void setProduct_specification(String product_specification) {
	this.product_specification = product_specification;
}

public String getProduct_Category() {
	return product_Category;
}

public void setProduct_Category(String product_Category) {
	this.product_Category = product_Category;
}

public double getproduct_price() {
	return product_price;
}

public void setproduct_price(double product_price) {
	this.product_price = product_price;
}

@Override
public String toString() {
	return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_specification="
			+ product_specification + ", product_Category=" + product_Category + ", product_price=" + product_price + "]";
}

}

package com.app;

//changes
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.data.Inventory;
import com.service.ShoppingCart;

public class EcomData {
private Inventory inv;
private ShoppingCart sc;

public static void main(String[] args) {
	Scanner scnr = new Scanner(System.in);
	Inventory inv = new Inventory();
	ShoppingCart sc = new ShoppingCart();
	int choice = 0;
		
	do {	
		try
		{
	System.out.println("*******Shopping Cart*******");
	System.out.println("1. List Available Products");
	System.out.println("2. Search Products");
	System.out.println("3. Add Products");
	System.out.println("4. View Cart");
	System.out.println("5. Checkout Cart");	
	System.out.println("6. Exit");
	System.out.println("Enter your choice: ");
	
	choice = scnr.nextInt();
	
	switch(choice) {
	case 1: 
		System.out.println("---List of Available Products---");
		inv.displayItems();
		break;
	case 2: 
		System.out.println("---Search Product---");
		System.out.println("Enter product: ");
		String item = scnr.next();
		System.out.println(inv.searchProducts(item));
		break;
	case 3: 
		System.out.println("---Add Product To Cart---");
		System.out.println("Enter productid: ");
		int prid = scnr.nextInt();
		System.out.println("Enter quantity: ");
		int prqn = scnr.nextInt();
		List<Product> lp = inv.searchProductids(prid);
		String prname = lp.stream().findFirst().map(e -> e.getProduct_name()).orElse("");
		String prspec = lp.stream().findFirst().map(e -> e.getProduct_specification()).orElse("");
		String prcategory = lp.stream().findFirst().map(e -> e.getProduct_Category()).orElse("");
		double prprice = lp.stream().mapToDouble(e -> e.getproduct_price()).findFirst().orElse(0.0);
		Product newpr = new Product(prid,prname,prspec,prcategory,prprice);		
		sc.addProduct(newpr, prqn);
		break;
	case 4: 
		System.out.println("---View Product In Cart---");
		sc.viewProduct();
		break;
	case 5: 
		System.out.println("---Checkout Cart---");
		System.out.println("***Products in cart*** ");
		sc.viewProduct();
		System.out.println("Total Amount in cart: "+ sc.totalAmount());
		break;	
	case 6: 
		System.out.println("Exit!!!");
		break;
		default:
			System.out.println("Invalid choice!");
	}
		
		}
	catch(Exception e){
		System.out.println("Integer value expected!. Please enter a valid choice: ");
		scnr.nextLine();
	}	
	
	}while(choice!=6);	
}
}
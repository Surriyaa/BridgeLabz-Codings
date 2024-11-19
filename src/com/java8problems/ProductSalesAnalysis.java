package com.java8problems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class Product{
		private int productId;
		private int quantity;
		private double price;
		public Product(int productId, int quantity, double price) {

			this.productId = productId;
			this.quantity = quantity;
			this.price = price;
		}
		public int getProductId() {
			return productId;
		}
		public int getQuantity() {
			return quantity;
		}
		public double getPrice() {
			return price;
		}
		
		public double totalRevenue() {
			return quantity*price;
		}
		
		public String toString() {
			return String.format("\nProduct ID: %d,\n Quantity :%d,\n Price: %.2f",
					productId,quantity,price);
		}
	}
	
	public class ProductSalesAnalysis {
	
		public static void main(String[] args) {
			
			List<Product> products=Arrays.asList(new Product(10,50,50.00),
					new Product(11,5,50.00),
					new Product(12,20,250.00),
					new Product(13,80,550.00),
					new Product(15,5,100.00)
					);
			
			List<Product> quantityGreaterThan10=products.stream().filter(quan->quan.getQuantity()>10)
					.toList();
			
			System.out.println(" sales where the quantity sold is greater than 10");
			System.out.println(quantityGreaterThan10);
			
			List<Map.Entry<Integer, Double>> totalRevenue =products.stream().map(p-> Map.entry(p.getProductId(),p.totalRevenue()))
					.toList();
			
			totalRevenue.forEach(entry-> 
			System.out.printf("Product ID: %d, Product Tot Revenue: %.2f ",entry.getKey(),entry.getValue()));
			
			List<Map.Entry<Integer, Double>> sortByDesc=totalRevenue.stream().sorted((e1,e2)->
			Double.compare(e2.getValue(), e1.getValue()))
					.toList();
			
			System.out.println("\nSorted by Revenue Desc\n");
			sortByDesc.forEach(entry -> 
            System.out.printf("Product ID: %d, Total Revenue: %.2f%n", entry.getKey(), entry.getValue()));
			
			List<Map.Entry<Integer, Double>> top5=sortByDesc.stream()
					.limit(5).toList();
			
			top5.forEach(entry->
			System.out.printf("Product ID: %d, Product Tot Revenue: %.2f ",entry.getKey(),entry.getValue()));
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
		}
	
	}

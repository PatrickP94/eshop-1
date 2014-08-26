package eshop;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named("catalog")
@ApplicationScoped
public class Catalog {
	private List<Product> products;
	
	public Catalog(){
		products = new ArrayList<Product>();
		products.add(new Product("p1", "Pencil", 1.20));
		products.add(new Product("p2", "Eraser", 2.00));
		products.add(new Product("p3", "Ball pen", 3.50));
	}
	
	public List<Product> getProducts(){
		return products;
	}
}

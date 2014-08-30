package eshop;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("ph")
@RequestScoped
public class ProductHolder {
	
	private Product currentProduct;

	@Inject
	private Cart cart;
	
	@Inject
	private Catalog catalog;

	public Product getCurrentProduct() {
		return currentProduct;
	}

	public void setCurrentProduct(Product currentProduct) {
		System.err.println("current product: " + currentProduct.getName());
		this.currentProduct = currentProduct;
	}
	
	public String getProductId(){
		return currentProduct != null ? currentProduct.getId() : null;
	}
	
	public void setProductId(String pid){
		currentProduct = catalog.getProduct(pid);
	}

	public String addToCart() {
		System.out.println("Adding " + currentProduct.getId());
		cart.add(currentProduct.getId());
		return "added";
	}
}

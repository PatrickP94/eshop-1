package eshop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("cart")
@SessionScoped
public class Cart implements Serializable{
	List<String> productIds;
	
	public Cart(){
		productIds = new ArrayList<String>();
	}
	
	public void add(String pid){
		productIds.add(pid);
	}
	
	public List<String> getProductIds(){
		return productIds;
	}
}

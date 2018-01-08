package com.supermarket.collections;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.stereotype.Component;
/**
 * Provides the collection class return 
 * all the items added to cart in a session
 *
 */
@Component
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS, value="session")
public class CheckoutCart {
	@Id
	private String id;
	
	@DBRef
	private List<CartItems> cartItems = new ArrayList<>();
	
	

	public List<CartItems> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}

	
	
	public Double getTotalAmount(){
	    double totalAmount = cartItems
		    .stream()
		    .mapToDouble(item -> item.getAmount().doubleValue())
		    .sum();
	    
	    return totalAmount;
	}
}

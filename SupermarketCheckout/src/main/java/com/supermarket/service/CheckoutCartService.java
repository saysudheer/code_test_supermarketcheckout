package com.supermarket.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.supermarket.collections.CartItems;
import com.supermarket.collections.CheckoutCart;
import com.supermarket.repository.CheckoutCartrepository;

@Service
public class CheckoutCartService {
	

	    @Autowired
	    private CheckoutCartrepository checkoutCartrepository;

	   
	    @Autowired
	    private HttpSession	 httpSession;

	    @Transactional
	    public CheckoutCart findOne(String id) {
		return checkoutCartrepository.findOne(id);
	    }

	    @Transactional
	    public void save(CheckoutCart checkoutCart) {
	    	checkoutCartrepository.save(checkoutCart);
	    }

	    
	    public void insert(CartItems cartItems) {
	    	CheckoutCart checkoutCart = getCheckoutCartSession();
	    	
	    	
	    	checkoutCart.getCartItems().add(cartItems);
		httpSession.setAttribute("checkoutCart", checkoutCart);
	}

	    public CheckoutCart getCheckoutCartSession() {
	    	CheckoutCart checkoutCart = (CheckoutCart) this.httpSession.getAttribute("checkoutCart");
		if (checkoutCart == null) {
			checkoutCart = new CheckoutCart();
		    this.httpSession.setAttribute("checkoutCart", checkoutCart);
		}
		return checkoutCart;
	    }
	}
package com.supermarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.supermarket.collections.CartItems;
import com.supermarket.repository.CartItemsRepository;

@Service
public class CartItemService {
	
	@Autowired
    private CartItemsRepository cartItemsRepository;
    
   
    
    @Transactional
    public void save(CartItems cartitem){
    	
    	cartItemsRepository.save(cartitem);
    }
}

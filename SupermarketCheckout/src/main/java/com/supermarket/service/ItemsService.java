package com.supermarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.supermarket.collections.Items;
import com.supermarket.repository.ItemsRepository;

@Service
public class ItemsService {
	
	@Autowired
	private ItemsRepository itemsRepository;
    
   
    
    @Transactional
    public List<Items> findAll() {
    	return itemsRepository.findAll();
    }
    
    
}

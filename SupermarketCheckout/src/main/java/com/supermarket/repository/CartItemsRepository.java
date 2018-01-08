package com.supermarket.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.supermarket.collections.CartItems;

public interface CartItemsRepository extends MongoRepository<CartItems, Integer> {

		List<CartItems> findItemById();
}

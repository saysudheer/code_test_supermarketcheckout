package com.supermarket.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.supermarket.collections.CheckoutCart;

public interface CheckoutCartrepository extends MongoRepository<CheckoutCart, String> {

}

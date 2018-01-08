package com.supermarket.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.supermarket.collections.Items;

public interface ItemsRepository extends MongoRepository<Items, Integer> {

}

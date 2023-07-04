package com.erpcooli.catalog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.erpcooli.catalog.document.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	Product findOneById(String id);
}

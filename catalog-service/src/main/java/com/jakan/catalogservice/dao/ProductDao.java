package com.jakan.catalogservice.dao;

import com.jakan.catalogservice.bean.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends MongoRepository<Product, String> {
}

package com.jakan.catalogservice.dao;

import com.jakan.catalogservice.bean.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends MongoRepository<Category, String> {
}

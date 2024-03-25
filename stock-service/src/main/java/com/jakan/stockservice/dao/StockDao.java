package com.jakan.stockservice.dao;

import com.jakan.stockservice.bean.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDao extends MongoRepository<Stock,String> {
}

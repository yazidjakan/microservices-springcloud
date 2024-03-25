package com.jakan.stockservice.dao;

import com.jakan.stockservice.bean.Warehouse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseDao extends MongoRepository<Warehouse,String> {
}

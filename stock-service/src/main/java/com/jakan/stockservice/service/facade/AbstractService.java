package com.jakan.stockservice.service.facade;

import java.util.List;

public interface AbstractService<D,I>{
    List<D> findAll();
    D save(D dto);
    void update(D dto);
    void delete(D dto);
    void deleteById(I id);
}

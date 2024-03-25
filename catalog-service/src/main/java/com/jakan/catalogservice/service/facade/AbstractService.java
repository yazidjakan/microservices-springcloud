package com.jakan.catalogservice.service.facade;

import java.util.List;

public interface AbstractService<D,I>{
    List<D> findAll();
    D findById(I id);
    D save(D dto);
    void update(D dto);
    void delete(D dto);
    void deleteById(I id);
}

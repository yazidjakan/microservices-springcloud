package com.jakan.catalogservice.transformer;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTransformer<E,D> {
    public abstract E toEntity (D dto);
    public abstract D toDto (E entity);
    public List<E> toEntity(List<D> dtos){
        if(dtos == null){
            return null;
        }else{
            List<E> entities=new ArrayList<>();
            for(D dto: dtos){
                entities.add(toEntity(dto));
            }
            return entities;
        }
    }
    public List<D> toDto(List<E> entities){
        if(entities == null){
            return null;
        }else{
            List<D> dtos=new ArrayList<>();
            for(E entity: entities){
                dtos.add(toDto(entity));
            }
            return dtos;
        }
    }
}

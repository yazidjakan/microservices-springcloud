package com.jakan.catalogservice.transformer;

import com.jakan.catalogservice.bean.Category;
import com.jakan.catalogservice.dto.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryTransformer extends AbstractTransformer<Category, CategoryDto>{
    @Override
    public Category toEntity(CategoryDto dto) {
        if(dto == null){
            return null;
        }else{
            Category entity=new Category();
            entity.setId(dto.id());
            entity.setNom(dto.nom());
            entity.setProducts(dto.products());
            return entity;
        }
    }

    @Override
    public CategoryDto toDto(Category entity) {
        if(entity == null){
            return null;
        }else{
            CategoryDto dto=new CategoryDto(
                    entity.getId(),
                    entity.getNom(),
                    entity.getProducts()
            );
            return dto;
        }
    }
}

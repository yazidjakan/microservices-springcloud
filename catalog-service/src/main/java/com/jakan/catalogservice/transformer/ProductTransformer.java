package com.jakan.catalogservice.transformer;

import com.jakan.catalogservice.bean.Product;
import com.jakan.catalogservice.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductTransformer extends AbstractTransformer<Product, ProductDto> {
    @Override
    public Product toEntity(ProductDto dto) {
        if(dto == null){
            return null;
        }else{
            Product entity=new Product();
            entity.setId(dto.id());
            entity.setNomProduct(dto.nomProduct());
            entity.setDescription(dto.description());
            entity.setPrix(dto.prix());
            entity.setCatalog(dto.category());
            return entity;
        }
    }

    @Override
    public ProductDto toDto(Product entity) {
        if(entity == null){
            return null;
        }else{
            ProductDto dto=new ProductDto(
                    entity.getId(),
                    entity.getNomProduct(),
                    entity.getDescription(),
                    entity.getPrix(),
                    entity.getCatalog()
            );
            return dto;
        }
    }
}

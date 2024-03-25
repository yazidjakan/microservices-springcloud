package com.jakan.stockservice.transformer;

import com.jakan.stockservice.bean.Stock;
import com.jakan.stockservice.dto.StockDto;
import org.springframework.stereotype.Component;

@Component
public class StockTransformer extends AbstractTransformer<Stock, StockDto> {
    @Override
    public Stock toEntity(StockDto dto) {
        if(dto == null){
            return null;
        }else{
            Stock entity=new Stock();
            entity.setId(dto.id());
            entity.setLibelle(dto.libelle());
            entity.setCategorieId(dto.categorieId());
            entity.setProductId(dto.productId());
            return entity;
        }
    }

    @Override
    public StockDto toDto(Stock entity) {
        if(entity == null) {
            return null;
        }else{
            StockDto dto=new StockDto(
                    entity.getId(),
                    entity.getLibelle(),
                    entity.getCategorieId(),
                    entity.getProductId()
            );
            return dto;
        }
    }
}

package com.jakan.stockservice.transformer;

import com.jakan.stockservice.bean.Warehouse;
import com.jakan.stockservice.dto.WarehouseDto;
import org.springframework.stereotype.Component;

@Component
public class WarehouseTransformer extends AbstractTransformer<Warehouse, WarehouseDto>{
    @Override
    public Warehouse toEntity(WarehouseDto dto) {
        if(dto == null) {
            return null;
        }else{
            Warehouse entity=new Warehouse();
            entity.setId(dto.id());
            entity.setLibelle(dto.libelle());
            entity.setVille(dto.ville());
            entity.setStocks(dto.stocks());
            return entity;
        }
    }

    @Override
    public WarehouseDto toDto(Warehouse entity) {
        if(entity == null) {
            return null;
        }else{
            WarehouseDto dto=new WarehouseDto(
                    entity.getId(),
                    entity.getLibelle(),
                    entity.getVille(),
                    entity.getStocks()
            );
            return dto;
        }
    }
}

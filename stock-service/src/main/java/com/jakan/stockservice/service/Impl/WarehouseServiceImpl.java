package com.jakan.stockservice.service.Impl;

import com.jakan.stockservice.bean.Warehouse;
import com.jakan.stockservice.dao.WarehouseDao;
import com.jakan.stockservice.dto.WarehouseDto;
import com.jakan.stockservice.service.facade.AbstractService;
import com.jakan.stockservice.transformer.WarehouseTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements AbstractService<WarehouseDto, String> {
    private final WarehouseDao warehouseDao;
    private final WarehouseTransformer warehouseTransformer;
    @Override
    public List<WarehouseDto> findAll() {
        List<Warehouse> warehouses=warehouseDao.findAll();
        return warehouseTransformer.toDto(warehouses);
    }


    public WarehouseDto findById(String id) {
        Warehouse foundedWarehouse=warehouseDao.findById(id).orElseThrow();
        return warehouseTransformer.toDto(foundedWarehouse);
    }

    @Override
    public WarehouseDto save(WarehouseDto dto) {
        WarehouseDto foundedWarehouse=findById(dto.id());
        if(foundedWarehouse != null){
            throw new RuntimeException("Warehouse already exist !");
        }
        Warehouse transformedWarehouse=warehouseTransformer.toEntity(dto);
        Warehouse savedWarehouse=warehouseDao.save(transformedWarehouse);
        return warehouseTransformer.toDto(savedWarehouse);
    }

    @Override
    public void update(WarehouseDto dto) {
        WarehouseDto foundedWarehouse=findById(dto.id());
        Warehouse transformedWarehouse=warehouseTransformer.toEntity(foundedWarehouse);
        transformedWarehouse.setId(dto.id());
        transformedWarehouse.setLibelle(dto.libelle());
        transformedWarehouse.setVille(dto.ville());
        transformedWarehouse.setStocks(dto.stocks());
        warehouseDao.save(transformedWarehouse);
    }

    @Override
    public void delete(WarehouseDto dto) {
        WarehouseDto foundedWarehouse=findById(dto.id());
        Warehouse transformedWarehouse=warehouseTransformer.toEntity(foundedWarehouse);
        warehouseDao.delete(transformedWarehouse);
    }

    @Override
    public void deleteById(String id) {
        findById(id);
        warehouseDao.deleteById(id);
    }
}

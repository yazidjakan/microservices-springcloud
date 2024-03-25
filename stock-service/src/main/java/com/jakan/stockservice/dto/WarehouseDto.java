package com.jakan.stockservice.dto;

import com.jakan.stockservice.bean.Stock;

import java.util.List;

public record WarehouseDto(
        String id,
        String libelle,
        String ville,
        List<Stock> stocks
) {
}

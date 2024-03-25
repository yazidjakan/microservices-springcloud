package com.jakan.stockservice.dto;

import java.util.List;

public record StockDto(
        String id,
        String libelle,
        String categorieId,
        String productId
) {
}

package com.jakan.catalogservice.dto;

import com.jakan.catalogservice.bean.Product;

import java.util.List;

public record CategoryDto(
        String id,
        String nom,
        List<Product> products
) {
}

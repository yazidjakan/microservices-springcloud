package com.jakan.catalogservice.dto;

import com.jakan.catalogservice.bean.Category;

public record ProductDto(
        String id,
        String nomProduct,
        String description,
        double prix,
        Category category
) {
}

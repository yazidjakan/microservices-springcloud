package com.jakan.stockservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto{
    private String id;
    private String nomProduct;
    private String description;
    private double prix;
    private CategoryDto category;

}

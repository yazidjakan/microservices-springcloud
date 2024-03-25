package com.jakan.stockservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDto {
    private StockDto stockDto;
    private CategoryDto categoryDto;
    private ProductDto productDto;
}

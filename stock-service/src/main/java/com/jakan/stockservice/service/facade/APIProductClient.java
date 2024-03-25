package com.jakan.stockservice.service.facade;

import com.jakan.stockservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "catalog-service")
public interface APIProductClient {
    @GetMapping("api/v1/products/id/{product-id}")
    ProductDto getProduct(@PathVariable("product-id") String id);
}

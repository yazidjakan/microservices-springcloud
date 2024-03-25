package com.jakan.stockservice.service.facade;

import com.jakan.stockservice.dto.CategoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "catalog-service")
public interface APICategoryClient {
    @GetMapping("api/v1/categories/id/{category-id}")
    CategoryDto getCategory(@PathVariable("category-id") String id);
}

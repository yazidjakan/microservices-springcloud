package com.jakan.stockservice.service.Impl;

import com.jakan.stockservice.bean.Stock;
import com.jakan.stockservice.dao.StockDao;
import com.jakan.stockservice.dto.ApiResponseDto;
import com.jakan.stockservice.dto.CategoryDto;
import com.jakan.stockservice.dto.ProductDto;
import com.jakan.stockservice.dto.StockDto;
import com.jakan.stockservice.service.facade.APICategoryClient;
import com.jakan.stockservice.service.facade.APIProductClient;
import com.jakan.stockservice.service.facade.AbstractService;
import com.jakan.stockservice.transformer.StockTransformer;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements AbstractService<StockDto, String> {
    private final StockDao stockDao;
    private final StockTransformer stockTransformer;
    private final WebClient webClient;
    private final APICategoryClient apiCategoryClient;
    private final APIProductClient apiProductClient;
    @Override
    public List<StockDto> findAll() {
        List<Stock> stocks=stockDao.findAll();
        return stockTransformer.toDto(stocks);
    }

    @Retry(name = "{spring.application.name}", fallbackMethod = "getDefaultStock")
    public ApiResponseDto findById(String id) {
        Stock stock=stockDao.findById(id).get();

        ProductDto productDto=webClient.get()
                .uri("http://localhost:8080/api/v1/products/id/"+stock.getProductId())
                .retrieve()
                .bodyToMono(ProductDto.class)
                .block();
        CategoryDto categoryDto=webClient.get()
                .uri("http://localhost:8080/api/v1/categories/id/"+stock.getCategorieId())
                .retrieve()
                .bodyToMono(CategoryDto.class)
                .block();

        StockDto stockDto=stockTransformer.toDto(stock);

        ApiResponseDto apiResponseDto=new ApiResponseDto();
        apiResponseDto.setStockDto(stockDto);
        apiResponseDto.setCategoryDto(categoryDto);
        apiResponseDto.setProductDto(productDto);
        return apiResponseDto;
    }
    public ApiResponseDto getDefaultStock(String id, Exception exception){
        Stock stock=stockDao.findById(id).get();

        CategoryDto categoryDto=new CategoryDto();
        categoryDto.setNom("catégorie par defaut");
        categoryDto.setProduct("product par defaut");


        ProductDto productDto=new ProductDto();
        productDto.setNomProduct("product par defaut");
        productDto.setDescription("Research & Development");
        productDto.setPrix(0);
        productDto.setCategory(categoryDto);


        StockDto stockDto=stockTransformer.toDto(stock);

        ApiResponseDto apiResponseDto=new ApiResponseDto();
        apiResponseDto.setStockDto(stockDto);
        apiResponseDto.setProductDto(productDto);
        apiResponseDto.setCategoryDto(categoryDto);
        return apiResponseDto;

    }

    @Override
    public StockDto save(StockDto dto) {
        Stock transformedStock=stockTransformer.toEntity(dto);
        Stock savedStock=stockDao.save(transformedStock);
        return stockTransformer.toDto(savedStock);
    }

    @Override
    public void update(StockDto dto) {
        Stock foundedStock=stockDao.findById(dto.id()).orElseThrow();
        foundedStock.setId(dto.id());
        foundedStock.setLibelle(dto.libelle());
        foundedStock.setProductId(dto.productId());
        foundedStock.setCategorieId(dto.categorieId());
        stockDao.save(foundedStock);
    }

    @Override
    public void delete(StockDto dto) {
        Stock foundedStock=stockDao.findById(dto.id()).orElseThrow();
        stockDao.delete(foundedStock);
    }

    @Override
    public void deleteById(String id) {
        findById(id);
        stockDao.deleteById(id);
    }
}

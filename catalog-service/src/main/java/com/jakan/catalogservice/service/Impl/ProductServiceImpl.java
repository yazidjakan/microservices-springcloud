package com.jakan.catalogservice.service.Impl;

import com.jakan.catalogservice.bean.Product;
import com.jakan.catalogservice.dao.ProductDao;
import com.jakan.catalogservice.dto.ProductDto;
import com.jakan.catalogservice.service.facade.ProductService;
import com.jakan.catalogservice.transformer.ProductTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;
    private final ProductTransformer productTransformer;

    @Override
    public List<ProductDto> findAll() {
        List<Product> products=productDao.findAll();
        return productTransformer.toDto(products);
    }

    @Override
    public ProductDto findById(String id) {
        Product foundedProduct=productDao.findById(id).orElseThrow();
        ProductDto transformedProduct=productTransformer.toDto(foundedProduct);
        return transformedProduct;
    }

    @Override
    public ProductDto save(ProductDto dto) {
        ProductDto foundedProduct=findById(dto.id());
        if(foundedProduct != null){
            throw new RuntimeException("Product est déjà enregistré dans la base de données");
        }
        Product transformedProduct=productTransformer.toEntity(dto);
        Product savedProduct=productDao.save(transformedProduct);
        return productTransformer.toDto(savedProduct);
    }

    @Override
    public void update(ProductDto dto) {
        ProductDto foundedProduct=findById(dto.id());
        Product updatedProduct=productTransformer.toEntity(foundedProduct);
        updatedProduct.setId(dto.id());
        updatedProduct.setNomProduct(dto.nomProduct());
        updatedProduct.setPrix(dto.prix());
        updatedProduct.setDescription(dto.description());
        updatedProduct.setCatalog(dto.category());
        productDao.save(updatedProduct);
    }

    @Override
    public void delete(ProductDto dto) {
        ProductDto foundedProduct=findById(dto.id());
        Product transformedProduct=productTransformer.toEntity(foundedProduct);
        productDao.delete(transformedProduct);
    }

    @Override
    public void deleteById(String id) {
        findById(id);
        productDao.deleteById(id);
    }
}

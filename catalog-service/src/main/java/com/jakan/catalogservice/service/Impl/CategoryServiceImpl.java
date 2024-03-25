package com.jakan.catalogservice.service.Impl;

import com.jakan.catalogservice.bean.Category;
import com.jakan.catalogservice.dao.CategoryDao;
import com.jakan.catalogservice.dto.CategoryDto;
import com.jakan.catalogservice.service.facade.CategoryService;
import com.jakan.catalogservice.transformer.CategoryTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao catalogDao;
    private final CategoryTransformer catalogTransformer;


    @Override
    public List<CategoryDto> findAll() {
        List<Category> catalogs=catalogDao.findAll();
        return catalogTransformer.toDto(catalogs);
    }

    @Override
    public CategoryDto findById(String id) {
        Category foundedCatalog=catalogDao.findById(id).orElseThrow();
        return catalogTransformer.toDto(foundedCatalog);
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        CategoryDto existingCatalog=findById(dto.id());
        if(existingCatalog != null){
            throw new RuntimeException("Catalog est déjà enregistré dans la base de données");
        }
        Category transformedCatalog=catalogTransformer.toEntity(dto);
        Category savedCatalog=catalogDao.save(transformedCatalog);
        return catalogTransformer.toDto(savedCatalog);

    }

    @Override
    public void update(CategoryDto dto) {
        CategoryDto foundedCategory=findById(dto.id());
        Category transformedCatalog=catalogTransformer.toEntity(foundedCategory);
        transformedCatalog.setId(dto.id());
        transformedCatalog.setNom(dto.nom());
        transformedCatalog.setProducts(dto.products());
        catalogDao.save(transformedCatalog);
    }

    @Override
    public void delete(CategoryDto dto) {
        CategoryDto foundedCatalog=findById(dto.id());
        Category transformedCatalog=catalogTransformer.toEntity(foundedCatalog);
        catalogDao.delete(transformedCatalog);
    }

    @Override
    public void deleteById(String id) {
        findById(id);
        catalogDao.deleteById(id);
    }
}

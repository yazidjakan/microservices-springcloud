package com.jakan.catalogservice.ws;

import com.jakan.catalogservice.dto.CategoryDto;
import com.jakan.catalogservice.service.Impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalogs")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryServiceImpl catalogService;

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> findAll() {
        return ResponseEntity.ok(catalogService.findAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable String id) {
        return ResponseEntity.ok(catalogService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto dto) {
        return new ResponseEntity<>(catalogService.save(dto), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody CategoryDto dto) {
        catalogService.update(dto);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/")
    public ResponseEntity<Void> delete(@RequestBody CategoryDto dto){
        catalogService.delete(dto);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        catalogService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
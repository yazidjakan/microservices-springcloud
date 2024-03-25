package com.jakan.catalogservice.ws;

import com.jakan.catalogservice.dto.ProductDto;
import com.jakan.catalogservice.service.Impl.ProductServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable String id){
        return ResponseEntity.ok(productService.findById(id));
    }
    @PostMapping("/")
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto dto){
        return new ResponseEntity<>(productService.save(dto), HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody ProductDto dto){
        productService.update(dto);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/")
    public ResponseEntity<Void> delete(@RequestBody ProductDto dto){
        productService.delete(dto);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

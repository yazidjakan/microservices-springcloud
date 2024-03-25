package com.jakan.stockservice.ws;

import com.jakan.stockservice.dto.WarehouseDto;
import com.jakan.stockservice.service.Impl.WarehouseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/warehouses")
@RequiredArgsConstructor
public class WarehouseController {
    private final WarehouseServiceImpl warehouseService;

    @GetMapping("/")
    public ResponseEntity<List<WarehouseDto>> findAll(){
        return ResponseEntity.ok(warehouseService.findAll());
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<WarehouseDto> findById(@PathVariable String id){
        return ResponseEntity.ok(warehouseService.findById(id));
    }
    @PostMapping("/")
    public ResponseEntity<WarehouseDto> save(@RequestBody WarehouseDto dto){
        return new ResponseEntity<>(warehouseService.save(dto), HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody WarehouseDto dto){
         warehouseService.update(dto);
         return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/")
    public ResponseEntity<Void> delete(@RequestBody WarehouseDto dto){
        warehouseService.delete(dto);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        warehouseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

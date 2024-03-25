package com.jakan.stockservice.ws;

import com.jakan.stockservice.dto.ApiResponseDto;
import com.jakan.stockservice.dto.StockDto;
import com.jakan.stockservice.service.Impl.StockServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stocks")
@RequiredArgsConstructor
public class StockController {
    private final StockServiceImpl stockService;

    @GetMapping("/")
    public ResponseEntity<List<StockDto>> findAll(){
        return ResponseEntity.ok(stockService.findAll());
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<ApiResponseDto> findById(@PathVariable String id){
        ApiResponseDto apiResponseDto=stockService.findById(id);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<StockDto> save(@RequestBody StockDto dto){
        return new ResponseEntity<>(stockService.save(dto),HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody StockDto dto){
        stockService.update(dto);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/")
    public ResponseEntity<Void> delete(@RequestBody StockDto dto){
        stockService.update(dto);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        stockService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

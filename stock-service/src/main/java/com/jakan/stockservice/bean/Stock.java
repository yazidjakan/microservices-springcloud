package com.jakan.stockservice.bean;

import com.jakan.stockservice.dto.CategoryDto;
import com.jakan.stockservice.dto.ProductDto;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "stock")
public class Stock {
    @Id private String id;
    private String libelle;
    private String categorieId;
    private String productId;
}

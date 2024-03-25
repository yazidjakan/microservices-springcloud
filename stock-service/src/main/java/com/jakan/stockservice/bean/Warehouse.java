package com.jakan.stockservice.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "warehouse")
public class Warehouse {
    @Id private String id;
    private String libelle;
    private String ville;
    private List<Stock> stocks;
}

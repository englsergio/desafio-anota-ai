package com.lsalmeida.desafioanotaai.domain.product;

import com.lsalmeida.desafioanotaai.domain.category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
    @org.springframework.data.annotation.Id
    private String id;
    private String title;
    private String description;
    private String ownerId;
    private BigDecimal price;
    private Category category;
}

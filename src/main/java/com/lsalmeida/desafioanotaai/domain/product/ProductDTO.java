package com.lsalmeida.desafioanotaai.domain.product;

import com.lsalmeida.desafioanotaai.domain.category.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class ProductDTO {
    private String title;
    private String description;
    private String ownerId;
    private BigDecimal price;
    private Category category;
}

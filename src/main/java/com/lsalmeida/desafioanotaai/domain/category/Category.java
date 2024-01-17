package com.lsalmeida.desafioanotaai.domain.category;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Category {
    @org.springframework.data.annotation.Id
    private String id;
    private String title;
    private String description;
    private String ownerId;
}

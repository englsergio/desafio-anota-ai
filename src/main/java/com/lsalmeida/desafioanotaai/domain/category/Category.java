package com.lsalmeida.desafioanotaai.domain.category;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Category {
    @org.springframework.data.annotation.Id
    private String Id;
    private String title;
    private String description;
    private String ownerId;
}

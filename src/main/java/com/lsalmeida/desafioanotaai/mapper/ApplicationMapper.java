package com.lsalmeida.desafioanotaai.mapper;

import com.lsalmeida.desafioanotaai.domain.category.Category;
import com.lsalmeida.desafioanotaai.domain.category.CategoryDTO;
import com.lsalmeida.desafioanotaai.domain.product.Product;
import com.lsalmeida.desafioanotaai.domain.product.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ApplicationMapper {

    @Mapping(target = "ownerId", ignore = true)
    Category toEntity(CategoryDTO dto);

    CategoryDTO toDTO(Category entity);

    @Mapping(target = "ownerId", ignore = true)
    Product toEntity(ProductDTO dto);

    ProductDTO toDTO(Product entity);
}

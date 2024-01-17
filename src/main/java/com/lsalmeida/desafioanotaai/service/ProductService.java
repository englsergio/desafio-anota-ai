package com.lsalmeida.desafioanotaai.service;

import com.lsalmeida.desafioanotaai.domain.category.Category;
import com.lsalmeida.desafioanotaai.domain.product.Product;
import com.lsalmeida.desafioanotaai.domain.product.ProductDTO;
import com.lsalmeida.desafioanotaai.exception.CategoryNotFoundException;
import com.lsalmeida.desafioanotaai.exception.ProductNotFoundException;
import com.lsalmeida.desafioanotaai.mapper.ApplicationMapper;
import com.lsalmeida.desafioanotaai.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ApplicationMapper mapper;

    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public ProductDTO insert(ProductDTO dto) throws CategoryNotFoundException {
        Optional<Category> optionalCategory = categoryService.findById(dto.getCategory().getId());
        optionalCategory.orElseThrow(CategoryNotFoundException::new);
        dto.setCategory(optionalCategory.get());
        return mapper.toDTO(productRepository.insert(mapper.toEntity(dto)));
    }

    public ProductDTO update(ProductDTO dto, String id) throws ProductNotFoundException {
        productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        Product entity = mapper.toEntity(dto);
        categoryService.findById(dto.getCategory().getId()).ifPresent(entity::setCategory);
        entity.setId(id);
        return mapper.toDTO(productRepository.save(entity));
    }

    public void delete(String id) throws ProductNotFoundException {
        productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        productRepository.deleteById(id);
    }

}

package com.lsalmeida.desafioanotaai.service;

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
        categoryService.findById(dto.getCategory().getId()).orElseThrow(CategoryNotFoundException::new);
        return mapper.toDTO(productRepository.insert(mapper.toEntity(dto)));
    }

    public ProductDTO update(ProductDTO dto, String id) throws CategoryNotFoundException, ProductNotFoundException {
        productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        categoryService.findById(dto.getCategory().getId()).orElseThrow(CategoryNotFoundException::new);
        Product entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDTO(productRepository.save(entity));
    }

    public void delete(String id) throws ProductNotFoundException {
        productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        productRepository.deleteById(id);
    }

}

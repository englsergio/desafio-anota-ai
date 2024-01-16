package com.lsalmeida.desafioanotaai.controller;

import com.lsalmeida.desafioanotaai.domain.product.Product;
import com.lsalmeida.desafioanotaai.domain.product.ProductDTO;
import com.lsalmeida.desafioanotaai.exception.CategoryNotFoundException;
import com.lsalmeida.desafioanotaai.exception.ProductNotFoundException;
import com.lsalmeida.desafioanotaai.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/id")
    public ResponseEntity<Product> findById(@RequestParam String id) {
        return ResponseEntity.of(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto) throws CategoryNotFoundException {
        return ResponseEntity.ok(service.insert(dto));
    }

    @PutMapping
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO dto, String id) throws CategoryNotFoundException, ProductNotFoundException {
        return ResponseEntity.ok(service.update(dto, id));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(String id) throws ProductNotFoundException {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}

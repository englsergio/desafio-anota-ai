package com.lsalmeida.desafioanotaai.controller;

import com.lsalmeida.desafioanotaai.domain.category.Category;
import com.lsalmeida.desafioanotaai.domain.category.CategoryDTO;
import com.lsalmeida.desafioanotaai.exception.CategoryNotFoundException;
import com.lsalmeida.desafioanotaai.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @GetMapping("/id")
    public ResponseEntity<Category> findById(@RequestParam(name = "id") String id) {
        return ResponseEntity.of(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
    }

    @PutMapping
    public ResponseEntity<CategoryDTO> update(@RequestParam(name = "id") String id, @RequestBody CategoryDTO dto)
            throws CategoryNotFoundException {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String id) throws ClassNotFoundException {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}

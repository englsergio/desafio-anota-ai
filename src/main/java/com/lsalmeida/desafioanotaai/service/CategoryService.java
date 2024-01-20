package com.lsalmeida.desafioanotaai.service;

import com.lsalmeida.desafioanotaai.domain.category.Category;
import com.lsalmeida.desafioanotaai.domain.category.CategoryDTO;
import com.lsalmeida.desafioanotaai.exception.CategoryNotFoundException;
import com.lsalmeida.desafioanotaai.mapper.ApplicationMapper;
import com.lsalmeida.desafioanotaai.repository.CategoryRepository;
import com.lsalmeida.desafioanotaai.service.aws.AwsSnsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;
    private final ApplicationMapper mapper;

    public Optional<Category> findById(String id) {
        return this.repository.findById(id);
    }

    public List<Category> findAll() {
        return this.repository.findAll();
    }

    public CategoryDTO insert(CategoryDTO dto) {
        Category category = mapper.toEntity(dto);
        return mapper.toDTO(this.repository.save(category));
    }

    public CategoryDTO update(String id, CategoryDTO dto) throws CategoryNotFoundException {
        this.repository.findById(id).orElseThrow(CategoryNotFoundException::new);
        Category category = mapper.toEntity(dto);
        category.setId(id);
        return mapper.toDTO(repository.save(category));
    }

    public void delete(String id) throws ClassNotFoundException {
        repository.findById(id).orElseThrow(ClassNotFoundException::new);
        this.repository.deleteById(id);
    }

}

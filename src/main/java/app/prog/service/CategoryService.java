package app.prog.service;

import app.prog.exception.NotFoundException;
import app.prog.model.CategoryEntity;
import app.prog.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryEntity getCategoryById(int id) {
        CategoryEntity category = repository.findById(id)
                .orElseThrow(()->new NotFoundException("CategoryEntity." + id + " not found"));
        return category;
    }

}

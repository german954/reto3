package com.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import com.reto3.reto3.model.Category;
import com.reto3.reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategoryAll() {
        return categoryRepository.getCategoryAll();
    }

    public Optional<Category> getCategoryId(Integer id) {
        return categoryRepository.getCategoryId(id);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<Category> categoryAuxiliar = categoryRepository.getCategoryId(category.getId());
            if (categoryAuxiliar.isEmpty()) {
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }

    public Category update(Category category) {
        if (category.getId() != null) {
            Optional<Category> categoryAuxiliar = categoryRepository.getCategoryId(category.getId());
            if (!categoryAuxiliar.isEmpty()) {
                if (category.getDescription() != null) {
                    categoryAuxiliar.get().setDescription(category.getDescription());
                }
                if (category.getName() != null) {
                    categoryAuxiliar.get().setName(category.getName());
                }
                return categoryRepository.save(categoryAuxiliar.get());
            }
        }
        return category;
    }

    public boolean deleteCategory(Integer categoryId) {
        boolean flag = false;
        Optional<Category> categoryAuxiliar = categoryRepository.getCategoryId(categoryId);
        if (categoryAuxiliar.isPresent()) {
            categoryRepository.delete(categoryAuxiliar.get());
            flag = true;
        }
        return flag;
    }
}




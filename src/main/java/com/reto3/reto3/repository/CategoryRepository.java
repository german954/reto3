package com.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.reto3.reto3.model.Category;
import com.reto3.reto3.repository.crud.CategoryCrudRepository;

@Repository
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getCategoryAll() {
        return (List<Category>) categoryCrudRepository.findAll();
    }

    public Optional<Category> getCategoryId(Integer id) {
        return categoryCrudRepository.findById(id);
    }

    public Category save(Category category) {
        return categoryCrudRepository.save(category);
    }

    /*public Optional<Category> update(Integer id) {
        return categoryCrudRepository.findById(id);
    }*/

    public void delete(Category category) {
        categoryCrudRepository.delete(category);
    }
}

package com.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto3.reto3.model.Skate;
import com.reto3.reto3.repository.crud.SkateCrudRepository;

@Repository
public class SkateRepository {

    @Autowired
    private SkateCrudRepository skateCrudRepository;

    public List<Skate> getSkateAll() {
        return (List<Skate>) skateCrudRepository.findAll();
    }

    public Optional<Skate> getSkateId(Integer id) {
        return skateCrudRepository.findById(id);
    }

    public Skate save(Skate skate) {
        return skateCrudRepository.save(skate);
    }

    public void delete(Skate skate) {
        skateCrudRepository.delete(skate);
    }
}

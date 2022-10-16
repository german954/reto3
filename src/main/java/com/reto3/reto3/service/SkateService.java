package com.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reto3.reto3.model.Skate;
import com.reto3.reto3.repository.SkateRepository;

@Service
public class SkateService {

    @Autowired
    private SkateRepository skateRepository;

    public List<Skate> getSkateAll() {
        return skateRepository.getSkateAll();
    }

    public Optional<Skate> getSkateId(Integer id) {
        return skateRepository.getSkateId(id);
    }

    public Skate save(Skate skate) {
        if (skate.getId() == null) {
            return skateRepository.save(skate);
        } else {
            Optional<Skate> skateAuxiliar = skateRepository.getSkateId(skate.getId());
            if (skateAuxiliar.isEmpty()) {
                return skateRepository.save(skate);
            } else {
                return skate;
            }
        }
    }

    public Skate update(Skate skate) {
        if (skate.getId() != null) {
            Optional<Skate> skateAuxiliar = skateRepository.getSkateId(skate.getId());
            if (!skateAuxiliar.isEmpty()) {
                if (skate.getName() != null) {
                    skateAuxiliar.get().setName(skate.getName());
                }
                if (skate.getYear() != null) {
                    skateAuxiliar.get().setYear(skate.getYear());
                }
                if (skate.getBrand() != null) {
                    skateAuxiliar.get().setBrand(skate.getBrand());
                }
                if (skate.getDescription() != null) {
                    skateAuxiliar.get().setDescription(skate.getDescription());
                }
                if (skate.getCategory() != null) {
                    skateAuxiliar.get().setCategory(skate.getCategory());
                }
                skateRepository.save(skateAuxiliar.get());
                return skateRepository.save(skateAuxiliar.get());
            } else {
                return skate;
            }
        } else {
            return skate;
        }
    }

    public boolean deleteSkate(Integer skateId) {
        boolean flag = false;
        Optional<Skate> skateAuxiliar = skateRepository.getSkateId(skateId);
        if (skateAuxiliar.isPresent()) {
            skateRepository.delete(skateAuxiliar.get());
            flag = true;
        }
        return flag;
    }
}
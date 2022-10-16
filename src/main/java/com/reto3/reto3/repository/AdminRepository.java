package com.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto3.reto3.model.Admin;
import com.reto3.reto3.repository.crud.AdminCrudRepository;

@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepository adminCrudRepository;

    /*public List<Admin> getAdminAll() {
        return (List<Admin>) adminCrudRepository.findAll();
    }

    public Optional<Admin> getAdminId(Integer id) {
        return adminCrudRepository.findById(id);
    }

    public Admin save(Admin admin) {
        return adminCrudRepository.save(admin);
    }

    public void update(Admin admin){
        adminCrudRepository.update(admin);
    }
    public void delete(Admin admin) {
        adminCrudRepository.delete(admin);
    }*/
}

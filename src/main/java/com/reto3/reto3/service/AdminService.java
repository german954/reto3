package com.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import com.reto3.reto3.model.Admin;
import com.reto3.reto3.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAdminAll() {
        return adminRepository.getAdminAll();
    }

    public Optional<Admin> getAdminId(Integer adminId) {
        return adminRepository.getAdminId(adminId);
    }

    public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return adminRepository.save(admin);
        } else {
            Optional<Admin> adminAuxiliar = adminRepository.getAdminId(admin.getIdAdmin());
            if (adminAuxiliar.isEmpty()) {
                return adminRepository.save(admin);
            } else {
                return admin;
            }
        }
    }
/* 
    public Admin update(Admin admin){
        if(admin.getIdAdmin()!=null){
            Optional<Admin>adminAuxiliar = adminRepository.getAdminId(admin.getIdAdmin());
            if(!adminAuxiliar.isEmpty()){
                if(admin.getDescription()!=null){
                    adminAuxiliar.get().setDescription(admin.getIdAdmin());
                }
                if(admin.getName()!=null){
                    adminAuxiliar.get().setName(admin.getName());
                    }
                    return adminRepository.save(adminAuxiliar.get());
                }
            }
            return admin;
        }
    
    public boolean deleteCategory (Integer Id){
        boolean flag=false;
        Optional<Admin> adminAuxiliar= adminRepository.getAdminId(Id);
        if (adminAuxiliar.isPresent()){
            adminRepository.delete(adminAuxiliar.get());
        }
        return flag;
    } 
    */
    }

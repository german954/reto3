package com.reto3.reto3.controller;

import java.util.List;
import java.util.Optional;

import com.reto3.reto3.service.SkateService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reto3.reto3.model.Skate;

@RestController
@RequestMapping("/api/Skate")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SkateController {
    
    @Autowired
    private SkateService skateService;
    @GetMapping("/all")
    public List<Skate> getSkateAll(){
    return skateService.getSkateAll();
}

    @GetMapping("/{id}")
    public Optional<Skate> getSkateId(@PathVariable("id")Integer identificador){
    return skateService.getSkateId(identificador);

}
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate save(@RequestBody Skate skate){
    return skateService.save(skate);
}

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate update(@RequestBody Skate skate) {
        return skateService.update(skate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer skateId) {
        return skateService.deleteSkate(skateId);
    }

}

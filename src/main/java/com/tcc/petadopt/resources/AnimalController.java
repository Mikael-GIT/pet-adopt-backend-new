package com.tcc.petadopt.resources;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.petadopt.domain.Animal;
import com.tcc.petadopt.repositories.AnimalRepository;
@RestController
@RequestMapping("/animais")
public class AnimalController {
    
    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping
    public List<Animal> getAll(){
        return animalRepository.findAll();
    }

    @GetMapping("/{id}")
    public Animal getById(@PathVariable Integer id) throws Exception{
        return animalRepository.findById(id).orElseThrow(() -> new Exception());
    }

    @PostMapping
    public Animal save(@RequestBody Animal animal) throws Exception{
        return animalRepository.save(animal);
    }

}
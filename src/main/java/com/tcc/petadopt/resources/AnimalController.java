package com.tcc.petadopt.resources;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.petadopt.domain.Animal;
import com.tcc.petadopt.domain.dtos.AnimalPostDTO;
import com.tcc.petadopt.repositories.AnimalRepository;
import com.tcc.petadopt.repositories.CategoriaRepository;
@RestController
@RequestMapping("/animais")
@CrossOrigin
public class AnimalController {
    
    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Animal> getAll(){
        return animalRepository.findAll();
    }

    @GetMapping("/{id}")
    public Animal getById(@PathVariable Integer id) throws Exception{
        return animalRepository.findById(id).orElseThrow(() -> new Exception());
    }

    @PostMapping
    public Animal save(@RequestBody AnimalPostDTO dto) throws Exception{
        Animal animal = dto.toModel(dto, categoriaRepository);
        return animalRepository.save(animal);
    }

}
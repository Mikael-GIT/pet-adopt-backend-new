package com.tcc.petadopt.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.petadopt.domain.Animal;
import com.tcc.petadopt.domain.Categoria;
import com.tcc.petadopt.domain.dtos.AnimalPostDTO;
import com.tcc.petadopt.domain.dtos.RowsDTO;
import com.tcc.petadopt.repositories.AnimalRepository;
import com.tcc.petadopt.repositories.CategoriaRepository;
import com.tcc.petadopt.services.MapsService;
@RestController
@RequestMapping("/animais")
@CrossOrigin
public class AnimalController {
    
    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Animal> getAll(@PathVariable Integer cep){
        List<Animal> animais = animalRepository.findAll();
        return animais;
    }

    @GetMapping("/{id}")
    public Animal getById(@PathVariable Integer id, @PathVariable Integer cep) throws Exception{
        return animalRepository.findById(id).orElseThrow(() -> new Exception());
    }

    @PostMapping
    public Animal save(@RequestBody AnimalPostDTO dto) throws Exception{
        Animal animal = dto.toModel(dto, categoriaRepository);
        return animalRepository.save(animal);
    }

    @PutMapping
    public Animal update(@RequestBody AnimalPostDTO dto) throws Exception{
        Animal animal = animalRepository.findById(dto.getId()).orElseThrow(() -> new Exception("Não foi possível obter animal na base"));
        animal.setCor(dto.getCor());
        animal.setDescricao(dto.getDescricao());
        animal.setEndereco(dto.getEndereco());
        animal.setIdade(dto.getImagem());
        animal.setNome(dto.getNome());
        animal.setPorte(dto.getPorte());
        animal.setRaca(dto.getRaca());
        animal.setSexo(dto.getSexo());
        Categoria categoria = categoriaRepository.findById(dto.getCategoria_id()).orElseThrow(() -> new Exception("Não foi possível obter categoria na base"));
        animal.setCategoria(categoria);
        return animalRepository.save(animal);
    }

}
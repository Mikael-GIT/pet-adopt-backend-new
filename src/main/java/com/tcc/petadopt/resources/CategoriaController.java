package com.tcc.petadopt.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.petadopt.domain.Categoria;
import com.tcc.petadopt.domain.dtos.RowsDTO;
import com.tcc.petadopt.repositories.CategoriaRepository;
import com.tcc.petadopt.services.MapsService;

@RestController
@RequestMapping("/categorias")
@CrossOrigin
public class CategoriaController {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired MapsService mapsService;


    @GetMapping
    public List<Categoria> getAll(){
        return categoriaRepository.findAll();
    }

    @GetMapping("{id}")
    public Categoria getById(@PathVariable Integer id) throws Exception{
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new Exception("Não foi possível recuperar dados"));
        categoria.getAnimais().forEach(animal -> { 
            RowsDTO distances = mapsService.getDistanceBetweenCeps("26031481", Arrays.asList(animal.getEndereco().getCep()));
            animal.setDistancia(distances.getRows().get(0).getElements().get(0).getDistance().getText());
        });
        return categoria;
    }

    @PostMapping
    public Categoria save(@RequestBody Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    @PutMapping
    public Categoria update(@RequestBody Categoria categoria) throws Exception{
        Categoria categoriaFromBase = categoriaRepository.findById(categoria.getId()).orElseThrow(() -> new Exception("Não foi possível obter categoria da base"));
        categoriaFromBase.setImagem(categoria.getImagem());
        categoriaFromBase.setNome(categoria.getNome());
        return categoriaRepository.save(categoriaFromBase);
    }

}
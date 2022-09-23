package com.tcc.petadopt.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.petadopt.domain.Categoria;
import com.tcc.petadopt.domain.Usuario;
import com.tcc.petadopt.repositories.CategoriaRepository;
import com.tcc.petadopt.repositories.UsuarioRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Categoria> getAll(){
        return categoriaRepository.findAll();
    }

    @PostMapping
    public Categoria save(@RequestBody Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

}
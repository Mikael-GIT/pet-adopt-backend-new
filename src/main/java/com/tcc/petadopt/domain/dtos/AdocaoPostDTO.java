package com.tcc.petadopt.domain.dtos;

import org.springframework.beans.factory.annotation.Autowired;

import com.tcc.petadopt.domain.Adocao;
import com.tcc.petadopt.domain.Animal;
import com.tcc.petadopt.domain.Usuario;
import com.tcc.petadopt.repositories.AdocaoRepository;
import com.tcc.petadopt.repositories.AnimalRepository;
import com.tcc.petadopt.repositories.UsuarioRepository;

import lombok.Data;

@Data
public class AdocaoPostDTO {

    @Autowired

    private Integer animal_id;

    private Integer usuario_id;

    private String status;


    public Adocao toModel(AdocaoPostDTO dto, AnimalRepository animalRepository, UsuarioRepository usuarioRepository) throws Exception{
        Animal animalFromDataBase = animalRepository.findById(dto.getAnimal_id()).orElseThrow(() -> new Exception("Não foi possível obter animal da base."));
        Usuario usuarioFromDataBase = usuarioRepository.findById(dto.getUsuario_id()).orElseThrow(() -> new Exception("Não foi possível obter usuário da base."));
        Adocao adocao = new Adocao();
        adocao.setAnimal(animalFromDataBase);
        adocao.setUsuario(usuarioFromDataBase);
        adocao.setStatus(dto.getStatus());
        return adocao;
    }
}
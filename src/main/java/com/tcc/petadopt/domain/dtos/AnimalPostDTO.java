package com.tcc.petadopt.domain.dtos;

import org.springframework.beans.factory.annotation.Autowired;

import com.tcc.petadopt.domain.Animal;
import com.tcc.petadopt.domain.Categoria;
import com.tcc.petadopt.domain.Endereco;
import com.tcc.petadopt.repositories.CategoriaRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalPostDTO {

    private Integer id;

    private String nome;

    private String sexo;
    
    private String idade;

    private Boolean vacinado;

    private Boolean vermifugado;

    private String porte;

    private String cor;

    private String descricao;

    private String imagem;

    private String raca;

    private Endereco endereco;

    private Integer categoria_id;


    public Animal toModel(AnimalPostDTO dto, CategoriaRepository categoriaRepository) throws Exception{
        Animal animal = new Animal();
        animal.setNome(dto.getNome());
        animal.setCor(dto.getCor());
        animal.setDescricao(dto.getDescricao());
        animal.setIdade(dto.getIdade());
        animal.setImagem(dto.getImagem());
        animal.setPorte(dto.getPorte());
        animal.setSexo(dto.getSexo());
        animal.setRaca(dto.getRaca());
        animal.setVacinado(dto.getVacinado());
        animal.setVermifugado(dto.getVermifugado());
        animal.setStatus("disponivel");
        animal.setEndereco(dto.getEndereco());
        Categoria categoriaFromDataBase = categoriaRepository.findById(dto.getCategoria_id()).orElseThrow(() -> new Exception("Não foi possível obter categoria da base."));
        animal.setCategoria(categoriaFromDataBase);
        return animal;
    }

}
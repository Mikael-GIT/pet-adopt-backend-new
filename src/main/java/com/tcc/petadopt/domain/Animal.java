package com.tcc.petadopt.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String sexo;
    
    private String idade;

    private Boolean vacinado;

    private String porte;

    private String cor;

    private String descricao;

    private String imagem;

    private String raca;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categorias;
    
}
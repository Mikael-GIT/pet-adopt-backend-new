package com.tcc.petadopt.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    private Boolean vermifugado;
    
    @JsonIgnore
    @OneToOne(mappedBy = "animal")
    private Adocao adocao;

    @Embedded
    private Endereco endereco;
    
    @JsonBackReference
    @ManyToOne
	@JoinColumn(name = "categoria_id")
    private Categoria categoria;
    
}
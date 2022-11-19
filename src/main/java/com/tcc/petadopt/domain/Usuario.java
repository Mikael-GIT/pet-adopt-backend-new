package com.tcc.petadopt.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String idade;

    private String login;

    private String cpf;

    private String email;

    private Boolean admin;

    private String senha;

    private String telefone;

    private String profissao;

    private String linkFacebook;

    private String linkInstagram;

    private Boolean possuiOuPossuiuPets;

    private String motivoAdocao;

    private String numResidentesDomicilio;

    private Boolean residentesConcordamAdocao;

    private Boolean teraLivreAcessoAosComodos;
    
    private Boolean possuiBebeOuPretende;

    private Boolean residentesPossuiAlergia;

    private Boolean isCastrados;

    private Boolean concordaManterInformados;

    private Boolean aceitaVisitasPosAdocao;

    private Boolean adotouoOuDoouUmPet;

    private String tipoResidencia;

    private String ambientePropicioParaCriacao;


    @Embedded
    private Endereco endereco;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "usuario")
    private List<Adocao> adocao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

}
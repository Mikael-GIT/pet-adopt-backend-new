package com.tcc.petadopt.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Adocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String status = "aguardando";

    private Date data_solicitacao;

    private Date data_fim_solicitacao;
}
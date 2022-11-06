package com.tcc.petadopt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.petadopt.domain.Adocao;

@Repository
public interface AdocaoRepository extends JpaRepository<Adocao, Integer> {
     
}
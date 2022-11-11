package com.tcc.petadopt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tcc.petadopt.domain.Adocao;

@Repository
public interface AdocaoRepository extends JpaRepository<Adocao, Integer> {

    @Query(value = "select * from ADOCAO where USUARIO_ID = 1", nativeQuery = true)
    List<Adocao> findAllAdoptionsByUserId(@Param("pUserId") Integer user_id);
}
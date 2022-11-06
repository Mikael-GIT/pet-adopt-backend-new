package com.tcc.petadopt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tcc.petadopt.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<com.tcc.petadopt.domain.Usuario, Integer> {

    @Query(value = "select * from usuario u where u.login = :pLogin and u.senha = :pSenha", nativeQuery = true)
    Usuario access(@Param("pLogin") String login, @Param("pSenha") String senha);
}